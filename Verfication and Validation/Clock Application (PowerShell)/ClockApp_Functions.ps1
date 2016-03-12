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

#region Adjust Day-Light Savings
function Enable-DST{
    param([Parameter(Mandatory=$true)][DateTime]$Current_Time)

        $Current_Time.AddHours(1)
}

function Disable-DST{
    param([Parameter(Mandatory=$true)][DateTime]$Current_Time)

    $Current_Time.AddHours(-1)
}