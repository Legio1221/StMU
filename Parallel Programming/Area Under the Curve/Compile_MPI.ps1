<#	
	.NOTES
	===========================================================================
	 Created with: 	SAPIEN Technologies, Inc., PowerShell Studio 2015 v4.2.81
	 Created on:   	4/30/2016 12:04 PM
	 Created by:   	Legio1221
	 Organization: 	ASTRA
	 Filename:     	
	===========================================================================
	.DESCRIPTION
		A description of the file.
#>

# Compiling paths (Unique to each PC)
# ==============================================================================
$SDK_MPI_Include = "C:\Program Files (x86)\Microsoft SDKs\MPI\Include"
$SDK_MPI_Include_64 = "C:\Program Files (x86)\Microsoft SDKs\MPI\Include\x64"

$SDK_MPI_Lib = "C:\Program Files (x86)\Microsoft SDKs\MPI\Lib\x64"
$SDK_Win_7_1A = "C:\Program Files (x86)\Microsoft SDKs\Windows\v7.1A\Include"
$VS_Include = "F:\ProgramFiles\VisualStudioCommunity2015\VC\include"

#$C_File = Read-Host "Name of c file?"
gcc -I $SDK_MPI_Include -I $SDK_MPI_Include_64 -c -o picalc.o picalc.c