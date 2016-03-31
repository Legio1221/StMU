<#	
	.NOTES
	===========================================================================
	 Created with: 	SAPIEN Technologies, Inc., PowerShell Studio 2015 v4.2.81
	 Created on:   	3/22/2016 6:28 PM
	 Created by:   	Legio1221
	 Organization: 	ASTRA
	 Filename:     	StMU_GAL.ps1
	===========================================================================
	.DESCRIPTION
		This script retrieves the global address list of a saint mary's university student.
	.REQUIREMENTS
		Outlook COM Application
	.OUTPUTS
		A text file with all of StMU's contact information.
#>

# Function Variables
# =====================================================================
$outlook = New-Object -ComObject Outlook.Application
$GAL = $outlook.Session.GetGlobalAddressList()
$AddressEntries = $GAL.AddressEntries
$ContactList = ""
$OutputFilePath = "C:\Users\Oscar Castro\Desktop\StMU_Contacts.stmu"
$counter = 0

$Divider = "==============================================="
Add-Content $OutputFilePath $Divider # Before looping, make sure first contact has a $Divider.

# Loop for each contact.
# ====================================================================
foreach ($entry in $AddressEntries)
{
	$counter++
	Write-Progress -Activity “Writing contacts to file” -status “Writing contact number: $counter” -percentComplete (($counter / $AddressEntries.Count) * 100)
	
	$Contact = $entry.GetExchangeUser()
	$FirstName = $Contact.FirstName
	$LastName = $Contact.LastName
	$Alias = $Contact.Alias
	$Email = $Contact.PrimarySmtpAddress
	
	$FirstNameString = "First Name: $FirstName"
	$LastNameString = "Last Name: $LastName"
	$FullNameString = "Full Name: $FirstName $LastName"
	$AliasString = "Alias: $Alias"
	$EmailString = "Email: $Email"
	$NewLine = "`n"
	
	$Output = $FullNameString + $NewLine + $FirstNameString + $NewLine + $LastNameString + $NewLine + $AliasString + $NewLine `
	+ $EmailString + $NewLine + $Divider
	
	Add-Content $OutputFilePath $Output
}