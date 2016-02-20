#!/usr/bin/env perl

use v5.10.0;
use warnings;
use strict;

use REST::Client;
use JSON;
use Data::Dumper;


my ($user, $api_key, $url, $json, $json_text, $data);
my ($city_id, $epoch, $time);
my ($infilename, $outfilename, $day);
my ($current_temp, $humidity, $speed);
my (@forecast);

# http://openweathermap.org/help/city_list.txt
$city_id = "4726206"; # San Antonio, TX

#-------------------------------------------------------
#            GET DATA FROM OPENWEATHERMAP 				|
#-------------------------------------------------------

# Obtain data from the webservice
$url = "http://api.openweathermap.org/data/2.5/forecast/daily?id=$city_id";
my $client = REST::Client -> new();
$client -> GET($url);
$json_text = $client -> responseContent();

#-----------------------------------------
#            SAVE FORECAST JSON 		  |
#-----------------------------------------
# Decode the JSON response
$json = JSON -> new();
$data = $json -> decode($json_text);

# Save JSON reponse to file
$outfilename = "forecast.json";
open OUTFILE, ">$outfilename" or die("Unable to open $outfilename\n");
print OUTFILE $json_text;
#print OUTFILE Dumper($data);
close OUTFILE;


# =======================================================================
# =======================================================================
# ||                                                                   ||
# ||                     END DATA RETRIEVAL						       ||
# ||                                                                   ||
# =======================================================================
# =======================================================================





#  ________________________________________________________________________
# |________________________________________________________________________|
# /             BEGIN DECODING JSON FILES		   						   \
# \________________________________________________________________________/
# |________________________________________________________________________|

# Read json from a file (for testing)
$infilename = "forecast.json";
open INFILE, "<$infilename" or die("Unable to open $infilename\n");
$json_text = <INFILE>;

#Decode JSON response.
$json = JSON -> new();
$data = $json -> decode($json_text);

# Extract the list of days
#Typically 7
@forecast = @{$data -> {"list"}};

#  ________________________________________________________________________
# |________________________________________________________________________|
# /                       END DECODING					   				   \
# \________________________________________________________________________/
# |________________________________________________________________________|



# +++++++++++++++++++++ HTML SMITHING ++++++++++++++++++++++++++++++++++


$outfilename ="forecast.html";

open OUTFILE, ">$outfilename" or die("Unable to open $outfilename");
print OUTFILE "<!DOCTYPE=html>\n";
print OUTFILE "<html>\n";
print OUTFILE "<title>Project 2</title>\n";

#Printing out the table of the 7 day forecast.
print OUTFILE "<table>\n";
print OUTFILE "<tr><th>Date         </th><th>Temperature</th><th>Humidity</th><th>Speed (MPS)</tr>\n";

#...loop stuff here (table)
# Process each day
foreach $day (@forecast)
{
	$epoch = $day -> {"dt"};
	$time = scalar localtime($epoch);
	$current_temp = $day -> {"temp"}{"day"} - 273.16;
	$humidity = $day -> {humidity};
	$speed = $day -> {speed};
	
	print OUTFILE "<tr><td>$time</td><td>$current_temp</td><td>$humidity</td><td>$speed</td></tr>";
}

print OUTFILE "</table>\n";
print OUTFILE "</html>\n";
close OUTFILE;
close INFILE;