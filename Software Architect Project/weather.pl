#!/usr/bin/env perl

use v5.10.0;
use warnings;
use strict;

use REST::Client;
use JSON;
#use Data::Dumper;
# Use for debugging.

#Variables
my ($url, $json_text, $json, $data);
my ($current_temp, $time, $epoch);
my ($outfilename, $infilename);

# =======================================================================
# =======================================================================
# ||                                                                   ||
# ||           Retrieval of data for Forecast and Weather              ||
# ||                                                                   ||
# =======================================================================
# =======================================================================

#------------------------------------------------------
#                 GET DATA FROM OPENWEATHERMAP 	       |
#------------------------------------------------------

#Using REST::Client to obtain
$url = 'http://api.openweathermap.org/data/2.5/weather?zip=78228,us';
my $client = REST::Client -> new();
$client -> GET($url);
$json_text = $client -> responseContent();

#-----------------------------------------
#          SAVE DATA TO JSON FILE         |
#-----------------------------------------

# Save JSON reponse to file
$outfilename = "weather.json";
open OUTFILE, ">$outfilename" or die("Unable to open $outfilename\n");
print OUTFILE $json_text;
close OUTFILE;

#  ________________________________________________________________________
# |________________________________________________________________________|
# /             BEGIN DECODING JSON FILES		   						   \
# \________________________________________________________________________/
# |________________________________________________________________________|

#Open weather.json for reading.
$infilename = "weather.json";
open INFILE, "<$infilename" or die("Unable to open $infilename\n");
$json_text = <INFILE>;

#Gotta decode that data.
$json = JSON -> new();
$data = $json -> decode($json_text);

#Obtain current temperature from data and convert it from Kelvin to Celsius.
$current_temp = $data -> {"main"}{"temp"} - 273.16;

#Obtain time. Must first convert from UNIX Epoch to GMT.
$epoch = $data -> {"dt"};
$time = scalar localtime($epoch);

close INFILE;

#++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
#++++++++++++             HTML SMIITHING            +++++++++++++++
#++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
$outfilename ="weather.html";

open OUTFILE, ">$outfilename" or die("Unable to open $outfilename");
print OUTFILE "<!DOCTYPE=html>\n";
print OUTFILE "<html>\n";
print OUTFILE "<title>Project 2</title>\n";

#Printing out the TIME and TEMPERATURE
print OUTFILE "<p>Date: $time\n</p>";
print OUTFILE "<p>Current temperature is $current_temp C\n</p>";

print OUTFILE "</html>\n";
close OUTFILE;
close INFILE;