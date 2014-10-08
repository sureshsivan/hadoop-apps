ftp://ftp.ncdc.noaa.gov/pub/data/noaa/1901/

lsblk
sudo mount /dev/xvdf public_dataset/weather1


http://s3.amazonaws.com/learn-hadoop/hadoop-infiniteskills-richmorrow-class.tgz;
http://s3.amazonaws.com/learn-hadoop/4-node-cluster-setup-script.txt

master1:50070   # hadoop GUI


tree /public_dataset/ -d;
/public_dataset/
├── infiniteskills
│   └── code-and-data
│       ├── code
│       │   ├── admin-tasks
│       │   ├── baseball
│       │   ├── benchmarking
│       │   ├── etl
│       │   ├── fair-scheduler
│       │   ├── flume-basics
│       │   ├── hdfs-basics
│       │   ├── hive-basics
│       │   ├── impala-basics
│       │   ├── logging
│       │   ├── partitioner
│       │   ├── pig-basics
│       │   ├── sqoop-basics
│       │   └── wordcount
│       └── data
│           ├── baseball
│           ├── gsod
│           │   └── 2014
│           ├── gsod-stations
│           ├── page_view
│           ├── shakespeare
│           ├── shakespeare-hdfs
│           └── world
└── weather1
    └── gsod
        ├── 1929
        ├── 1930
        ├── 1931
        ├── 1932
        ├── 1933
        ├── 1934
        ├── 1935
        ├── 1936
        ├── 1937
        ├── 1938
        ├── 1939
        ├── 1940
        ├── 1941
        ├── 1942
        ├── 1943
        ├── 1944
        ├── 1945
        ├── 1946
        ├── 1947
        ├── 1948
        ├── 1949
        ├── 1950
        ├── 1951
        ├── 1952
        ├── 1953
        ├── 1954
        ├── 1955
        ├── 1956
        ├── 1957
        ├── 1958
        ├── 1959
        ├── 1960
        ├── 1961
        ├── 1962
        ├── 1963
        ├── 1964
        ├── 1965
        ├── 1966
        ├── 1967
        ├── 1968
        ├── 1969
        ├── 1970
        ├── 1971
        ├── 1972
        ├── 1973
        ├── 1974
        ├── 1975
        ├── 1976
        ├── 1977
        ├── 1978
        ├── 1979
        ├── 1980
        ├── 1981
        ├── 1982
        ├── 1983
        ├── 1984
        ├── 1985
        ├── 1986
        ├── 1987
        ├── 1988
        ├── 1989
        ├── 1990
        ├── 1991
        ├── 1992
        ├── 1993
        ├── 1994
        ├── 1995
        ├── 1996
        ├── 1997
        ├── 1998
        ├── 1999
        ├── 2000
        ├── 2001
        ├── 2002
        ├── 2003
        ├── 2004
        ├── 2005
        ├── 2006
        ├── 2007
        ├── 2008
        └── 2009


Sample data set  [/public_dataset/weather1/gsod]
================================================
[0]    [7]    [14]        [26]       [37]      [47]      []
STN--- WBAN   YEARMODA    TEMP       DEWP      SLP        STP       VISIB      WDSP     MXSPD   GUST    MAX     MIN   PRCP   SNDP   FRSHTT
030050 99999  19291222    42.5  4    37.0  4   995.4  4  9999.9  0    7.8  4   23.9  4   36.9  999.9    44.1*   39.9  99.99  999.9  010000
030050 99999  19291223    42.0  4    37.2  4   995.0  4  9999.9  0    7.8  4   44.5  4   52.1  999.9    44.1    39.9  99.99  999.9  010000
030050 99999  19291224    40.5  4    34.2  4   998.6  4  9999.9  0    6.2  4   36.9  4   36.9  999.9    43.0*   37.0  99.99  999.9  010100
030050 99999  19291225    36.3  4    30.5  4   990.1  4  9999.9  0    4.3  4   44.5  4   52.1  999.9    39.9    34.0* 99.99  999.9  001000
030050 99999  19291226    36.0  4    29.8  4   988.2  4  9999.9  0   10.9  4   18.9  4   36.9  999.9    39.0    34.0* 99.99  999.9  001000
030050 99999  19291227    42.5  4    37.7  4   991.2  4  9999.9  0    7.8  4    5.4  4    8.9  999.9    45.0*   33.1  99.99  999.9  010000
030050 99999  19291228    40.0  4    35.0  4   990.5  4  9999.9  0   10.9  4    4.5  4    8.9  999.9    45.0    36.0   0.00I 999.9  000000
030050 99999  19291229    45.0  4    42.5  4   964.3  4  9999.9  0    4.3  4   15.2  4   36.9  999.9    46.9*   39.9  99.99  999.9  010000
030050 99999  19291230    41.2  4    36.2  4   977.2  4  9999.9  0    6.2  4   23.4  4   36.9  999.9    48.0    37.9  99.99  999.9  010000
030050 99999  19291231    38.7  4    34.0  4   996.9  4  9999.9  0   12.4  4    4.8  4    8.9  999.9    43.0    37.0   0.00I 999.9  000000



FIELD   POSITION  TYPE   DESCRIPTION

STN---  1-6       Int.   Station number (WMO/DATSAV3 number)
                         for the location.

WBAN    8-12      Int.   WBAN number where applicable--this is the
                         historical "Weather Bureau Air Force Navy"
                         number - with WBAN being the acronym.

YEAR    15-18     Int.   The year.

MODA    19-22     Int.   The month and day.

TEMP    25-30     Real   Mean temperature for the day in degrees
                         Fahrenheit to tenths.  Missing = 9999.9
                         (Celsius to tenths for metric version.)

Count   32-33     Int.   Number of observations used in
                         calculating mean temperature.

DEWP    36-41     Real   Mean dew point for the day in degrees
                         Fahrenheit to tenths.  Missing = 9999.9
                         (Celsius to tenths for metric version.)
Count   43-44     Int.   Number of observations used in
                         calculating mean dew point.

SLP     47-52     Real   Mean sea level pressure for the day
                         in millibars to tenths.  Missing =
                         9999.9
Count   54-55     Int.   Number of observations used in
                         calculating mean sea level pressure.

STP     58-63     Real   Mean station pressure for the day
                         in millibars to tenths.  Missing =
                         9999.9
Count   65-66     Int.   Number of observations used in
                         calculating mean station pressure.

VISIB   69-73     Real   Mean visibility for the day in miles
                         to tenths.  Missing = 999.9
                         (Kilometers to tenths for metric version.)
Count   75-76     Int.   Number of observations used in
                         calculating mean visibility.

WDSP    79-83     Real   Mean wind speed for the day in knots
                         to tenths.  Missing = 999.9
                         (Meters/second to tenths for metric version.)
Count   85-86     Int.   Number of observations used in
                         calculating mean wind speed.

MXSPD   89-93     Real   Maximum sustained wind speed reported
                         for the day in knots to tenths.
                         Missing = 999.9
                         (Meters/second to tenths for metric version.)

GUST    96-100    Real   Maximum wind gust reported for the day
                         in knots to tenths.  Missing = 999.9
                         (Meters/second to tenths for metric version.)

MAX     103-108   Real   Maximum temperature reported during the
                         day in Fahrenheit to tenths--time of max
                         temp report varies by country and
                         region, so this will sometimes not be
                         the max for the calendar day.  Missing =
                         9999.9
                         (Celsius to tenths for metric version.)
Flag    109-109   Char   Blank indicates max temp was taken from the
                         explicit max temp report and not from the
                         'hourly' data.  * indicates max temp was
                         derived from the hourly data (i.e., highest
                         hourly or synoptic-reported temperature).

MIN     111-116   Real   Minimum temperature reported during the
                         day in Fahrenheit to tenths--time of min
                         temp report varies by country and
                         region, so this will sometimes not be
                         the min for the calendar day.  Missing =
                         9999.9
                         (Celsius to tenths for metric version.)
Flag    117-117   Char   Blank indicates min temp was taken from the
                         explicit min temp report and not from the
                         'hourly' data.  * indicates min temp was
                         derived from the hourly data (i.e., lowest
                         hourly or synoptic-reported temperature).

PRCP    119-123   Real   Total precipitation (rain and/or melted
                         snow) reported during the day in inches
                         and hundredths; will usually not end
                         with the midnight observation--i.e.,
                         may include latter part of previous day.
                         .00 indicates no measurable
                         precipitation (includes a trace).
                         Missing = 99.99
                         (For metric version, units = millimeters
                         to tenths & missing = 999.9.)
                         Note:  Many stations do not report '0' on
                         days with no precipitation--therefore,
                         '99.99' will often appear on these days.
                         Also, for example, a station may only
                         report a 6-hour amount for the period
                         during which rain fell.
                         See Flag field for source of data.
Flag    124-124   Char   A = 1 report of 6-hour precipitation
                             amount.
                         B = Summation of 2 reports of 6-hour
                             precipitation amount.
                         C = Summation of 3 reports of 6-hour
                             precipitation amount.
                         D = Summation of 4 reports of 6-hour
                             precipitation amount.
                         E = 1 report of 12-hour precipitation
                             amount.
                         F = Summation of 2 reports of 12-hour
                             precipitation amount.
                         G = 1 report of 24-hour precipitation
                             amount.
                         H = Station reported '0' as the amount
                             for the day (eg, from 6-hour reports),
                             but also reported at least one
                             occurrence of precipitation in hourly
                             observations--this could indicate a
                             trace occurred, but should be considered
                             as incomplete data for the day.
                         I = Station did not report any precip data
                             for the day and did not report any
                             occurrences of precipitation in its hourly
                             observations--it's still possible that
                             precip occurred but was not reported.

SNDP    126-130   Real   Snow depth in inches to tenths--last
                         report for the day if reported more than
                         once.  Missing = 999.9
                         (Centimeters to tenths for metric version.)
                         Note:  Most stations do not report '0' on
                         days with no snow on the ground--therefore,
                         '999.9' will often appear on these days.

FRSHTT  133-138   Int.   Indicators (1 = yes, 0 = no/not
                         reported) for the occurrence during the
                         day of:
                         Fog ('F' - 1st digit).
                         Rain or Drizzle ('R' - 2nd digit).
                         Snow or Ice Pellets ('S' - 3rd digit).
                         Hail ('H' - 4th digit).
                         Thunder ('T' - 5th digit).
                         Tornado or Funnel Cloud ('T' - 6th
                         digit).

Sample data set  [/public_dataset/weather1/ish-history.txt]
===========================================================
USAF   WBAN  STATION NAME                  CTRY  ST CALL  LAT    LON     ELEV(.1M)

000000 99999 NYGGBUKTA GREENLAND- STA      GL GL          +73483 +021567 +00030
000010 99999 JAN HAYEN                     NO NO          +70983 -007700 +00229
000020 99999 ISFJORD RADIO SPITZBERGEN     NO NO          +78067 +013633 +00079
000030 99999 BJORNOYA BARENTS SEA          NO NO          +74467 +019283 +00290
000040 99999 VAROO                         NO NO          +70367 +031100 +00119
000050 99999 INGOY                         NO NO          +71067 +024150 +00040
000090 99999 ANDENES                       NO NO          +69317 +016133 +00070
000110 99999 ROST                          NO NO          +67500 +012067 +00110
000140 99999 RORODYAN                      NO NO          +64800 +010550 +00369


Sample data set  [/public_dataset/weather1/ish-history.csv]
===========================================================
"USAF","WBAN","STATION NAME","CTRY","FIPS","STATE","CALL","LAT","LON","ELEV(.1M)"
"000000","99999","NYGGBUKTA GREENLAND- STA","GL","GL","","","+73483","+021567","+00030"
"000010","99999","JAN HAYEN","NO","NO","","","+70983","-007700","+00229"
"000020","99999","ISFJORD RADIO SPITZBERGEN","NO","NO","","","+78067","+013633","+00079"
"000030","99999","BJORNOYA BARENTS SEA","NO","NO","","","+74467","+019283","+00290"
"000040","99999","VAROO","NO","NO","","","+70367","+031100","+00119"
"000050","99999","INGOY","NO","NO","","","+71067","+024150","+00040"
"000090","99999","ANDENES","NO","NO","","","+69317","+016133","+00070"
"000110","99999","ROST","NO","NO","","","+67500","+012067","+00110"
"000140","99999","RORODYAN","NO","NO","","","+64800","+010550","+00369"


USAF = Air Force Datsav3 station number
WBAN = NCDC WBAN number
CTRY = WMO historical country ID, followed by FIPS country ID
ST = State for US stations
CALL = ICAO call sign
LAT = Latitude in thousandths of decimal degrees
LON = Longitude in thousandths of decimal degrees
ELEV = Elevation in tenths of meters


Sample data set  [/public_dataset/weather1/country-list.txt]
===========================================================
FIPS ID     COUNTRY NAME

AA          ARUBA
AC          ANTIGUA AND BARBUDA
AF          AFGHANISTAN
AG          ALGERIA
AI          ASCENSION ISLAND
AJ          AZERBAIJAN
AL          ALBANIA
AM          ARMENIA
AN          ANDORRA
AO          ANGOLA
AQ          AMERICAN SAMOA
AR          ARGENTINA
AS          AUSTRALIA
AT          ASHMORE AND CARTIER ISLANDS




