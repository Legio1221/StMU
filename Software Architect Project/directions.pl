#!/usr/bin/perl

use strict;
use warnings;

use REST::Client;
use JSON;
use Data::Dumper;

my ($api_key, $output, $url, $json, $json_text, $data);
my ($origin, $destination);
my ($infilename, $outfilename, $step);
my ($instructions, $distance, $duration);
my (@routes, @legs, @steps);

#---------------------------------------------
#			 DATA RETRIEVAL					  |
#---------------------------------------------

$api_key = "AIzaSyA8APtk1839mZ7MARkvdDERfHyyD9ZZtoA";
$output = "json";
$origin = "San+Antonio+TX";
$destination = "Brownsville+TX";

# Construct the URL
$url="https://maps.googleapis.com/maps/api/directions/$output?";
$url .= "origin=$origin&destination=$destination&key=$api_key";

# Obtain data from the webservice
my $client = REST::Client -> new();
$client -> GET($url);
$json_text = $client -> responseContent();

#---------------------------------------------
#			END DATA RETRIEVAL				  |
#---------------------------------------------

#---------------------------------------------
#				 DECODE						  |
#---------------------------------------------

# Decode the JSON text
$json = JSON -> new();
$data = $json -> decode($json_text);
$data = decode_json($json_text);

#---------------------------------------------
#			END DECODE						  |
#---------------------------------------------

#---------------------------------------------
#			SAVE JSON						  |
#---------------------------------------------

# Save JSON reponse to file
$outfilename = "directions.json";
open OUTFILE, ">$outfilename" or die("Unable to open $outfilename\n");
print OUTFILE $json_text;
close OUTFILE;

#---------------------------------------------
#			END SAVE JSON					  |
#---------------------------------------------


#---------------------------------------------
#	  	 BEGIN DECODING MAP JSON			  |
#---------------------------------------------

# Read json from a file
#$infilename = "directions.json";
#open INFILE, "<$infilename" or die("Unable to open $infilename\n");
#$json_text = <INFILE>;
#close INFILE

# Decode the JSON text
#$json = JSON -> new();
#$data = $json -> decode($json_text);
#print Dumper $data;

# Extract the list of legs
@routes = @{$data -> {"routes"}};
@legs = @{$routes[0] -> {"legs"}};
@steps = @{$legs[0] -> {"steps"}};

#---------------------------------------------
#	  	 END DECODING MAP JSON			      |
#---------------------------------------------

#---------------------------------------------
#	  	 BEGIN HTML SMITHING  				  |
#---------------------------------------------

$outfilename ="map.html";

open OUTFILE, ">$outfilename" or die("Unable to open $outfilename");

# Header section of the HTML document.
print OUTFILE "<!DOCTYPE=html>\n";
print OUTFILE "<html>\n";
print OUTFILE "<title>Project 2 Maps</title>\n";
print OUTFILE "<body>\n";

# Body section.
print OUTFILE "<p>From $origin to $destination</p>";

# Loop for obtaining the instructions, duration, and distance.
foreach $step (@steps)
  {
    $instructions = $step -> {"html_instructions"};
    $duration = $step -> {"duration"}{"text"};
    $distance = $step -> {"distance"}{"text"};

    print OUTFILE "<p>$instructions \t$duration \t$distance</p>\n";
  }
  
# Embedded Google Map
# Embedded map with directions from origin to destination.
print OUTFILE "<p><iframe
  width=\"600\"
  height=\"450\"
  frameborder=\"0\" style=\"border:0\"
  src=\"https://www.google.com/maps/embed/v1/directions?key=$api_key
    &origin=$origin&destination=$destination\"></p>\n";

print OUTFILE "</body>\n";
print OUTFILE "</html>\n";

close OUTFILE;
#---------------------------------------------
#			END HTML SMITHING				  |
#---------------------------------------------
