#region UC1 - Time Mode Functions
function Select-24HourMode{
    #TODO
}

function Select-12HourMode{
    #TODO
}

function Select-HHMM{
    #TODO
}

function Select-HHMMSS{
    #TODO
}
#endregion

#region UC2 - Set Time Functions
# 1.   Setting the time must involve buttons
# 2.   Must enable Daylight Savings Time (DST)
# 3.   Software must decrement / increment time by any means?
# 4.   If the time mode is 24 hours and the hour is 23, it shall lap into 0 hours.

# Variables
#  $12HourConfig
#      $true  = 12 hour system configuration
#      $false = 24 hour system configuration

function Increment-Hour{

    # If $12HourConfig is false, then system assumes 24 hour setting
    param(` #[Parameter(Mandatory=$true)][boolean]$12HourConfig,
            [Parameter(Mandatory=$true)][DateTime]$Current_Time)

    $Current_Time.AddHours(1)

    return $Current_Time
}

function Decrement-Hour{

     param(` #[Parameter(Mandatory=$true)][boolean]$12HourConfig,
            [Parameter(Mandatory=$true)][DateTime]$Current_Time)

    $Current_Time.AddHours(-1)

    return $Current_Time
}

function Increment-Minute{
    param([Parameter(Mandatory=$true)][DateTime]$Current_Time)

    $Current_Time.AddMinute(1)

    return $Current_Time
}

function Decrement-Minute{
    param([Parameter(Mandatory=$true)][DateTime]$Current_Time)

    $Current_Time.AddMinute(-1)

    return $Current_Time
}
#endregion

#region UC3 - Adjust Day-Light Savings
function Enable-DST{
    param([Parameter(Mandatory=$true)][DateTime]$Current_Time)

        $Current_Time.AddHours(1)
}

function Disable-DST{
    param([Parameter(Mandatory=$true)][DateTime]$Current_Time)

    $Current_Time.AddHours(-1)
}
#endregion

#region UC4 - Select Time Zone
function Select-TimeZone{
    #TODO
    # Preload information into a combobox with all possible cases
    # It's gonna be a giant switch case.
}
#endregion

#region UC5 - View Time
function View-Time{

}
#endregion

#region UC6 - Set Alarms
#Logic Idea
<#
  1. Parse necessary information
  2. Set Alarm
  3. profit 
#>
#endregion

#region UC7 - Generate Alarm

# The line of code below loads an alarm sound, but it isn't suitable for testing.
#$alarm_sound = [Media.SoundPlayer]::new($PSScriptRoot + "\foo.wav")
$alarm_sound = [Media.SoundPlayer]::new("c:\users\oscar\desktop\castro alarm clock\foo.wav")
#endregion

#region UC8 - Reset Aalarm
function Silence-Alarm{
    param([Parameter(Mandatory=$true)][DateTime]$Current_Time)
}
#endregion

#region UC9 - Save User Settings / Retrieve / Parser
<#
$sloc = (Resolve-Path .\).Path
$configBase = "\config.ini"
$configLoc = $sloc + $configBase
$config_content = Get-Content $configLoc
$config_content

$global:Time_Zone = ""
$global:DST = 0
$global:Time = ""
$global:Alarm = ""

foreach($line in $config_content){
    $tempSplit = $line.split()
    $Config_Name = $tempSplit[0]
    $Config_Value = $tempSplit[2]
    switch($Config_Name){
        Time_Zone {$global:Time_Zone = $Config_Value; break}
        DST {$global:DST = $Config_Value; break}
        Time {$global:Time = $Config_Value + " " + $tempSplit[3..4]; break}
        Alarm {$global:Alarm = $Config_Value + $tempSplit[3]; break}
        default {Write-Host "Parsing Error!"; break}
    }
}
Write-Host "`n`n`n"
$global:Time_Zone
$global:DST
$global:Time
$global:Alarm
#>
#endregion