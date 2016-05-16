<#	
	.NOTES
	===========================================================================
	 Created with: 	SAPIEN Technologies, Inc., PowerShell Studio 2015 v4.2.81
	 Created on:   	4/30/2016 8:00 AM
	 Created by:   	Legio1221
	 Organization: 	ASTRA
	 Filename:     	
	===========================================================================
	.DESCRIPTION
		A .NET MPI MS-MPI hello world program.
#>

<#
$fullnames = New-Object ([System.Collections.Generic.List``1].MakeGenericType([String]));

function using ($name)
{
	foreach ($type in [Reflection.Assembly]::LoadWithPartialName($name).GetTypes())
	{
		$fullnames.Add($type.fullname);
	}
}

function new ($name)
{
	$fullname = $fullnames -like "*.$name";
	return, (New-Object $fullname[0]);
}

class MPIHello
{
	using (new MPI.Environment())
	{
		
	}
}#>

	new [MPI.Environment]
	$Comm = [MPI.Communicator]
	$Rank = $Comm.Rank

Write-Host "Hello World! from rank $Rank"
