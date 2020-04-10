BEGIN{
	old="[A-Za-z]{3}[0-9]{2}"
	new="[0-9]{2}:[0-9]{2}"
	latestUID="ZZZZZZZZZ"
	monthsArr= "Jan,Feb,Mar,May,Apr,Jun,Jul,Aug,Sep,Oct,Nov,Dec"
	split(monthsArr,months, ",")
	for (month in months){
		revMonths[months[month]]=month
	}
}
{
# associative array
	if(prevID != $1){
		print "User: " $1, "\t"
		prevID =$1
	}
	for(i=8; i<=NF; i++){
		printf(" " $i);
	}
	printf("\n");
}
{
# ------------Latest -------------------#
stime=$5
currUID=$1

	if(stime ~old && latest ~new){
		
	}
	else if(stime ~new && latest ~old){
		latest=stime
		latestUID=$1
		latestLine=$0
	}
	else if (stime ~new && stime ~new){
		if(latest < stime || (latest== stime && latestUID > currUID ))	{
		    latest=stime
		    latestUID=$1
		    latestLine=$0
		}
	}
	else if(stime ~ old && latest ~old){
		stimeMonth=stime
		stimeDay=stime
		latestMonth=latest
		latestDay=latest
	
		sub("[A-Z][a-z][a-z]","",stimeDay)
		sub("[0-9][0-9]", "",stimeMonth)
		stimeConv=revMonths[stimeMonth] stimeDay
			
		sub("[A-Z][a-z][a-z]","",latestDay)
		sub("[0-9][0-9]","",latestMonth)
		latestConv=revMonths[latestMonth] latestDay

		if(latestConv < stimeConv ||(latestConv == stimeConv && latestUID > currUID)){
			latest=stime
			latestUID=$1
			latestLine=$0
		}
	}
}
#--------------------Earliest-------------------#
{
stime=$5
currUID=$1

	if(stime ~old && earliest ~new){
		earliest=stime
		earliestUID = currUID
		earliestLine=$0
	}
	else if(stime ~new && earliest ~old){

	}
	else if (stime ~new && stime ~new){
		if(earliest < stime || (earliest== stime && earliestUID > currUID )) {
		earliest=stime
		earliestUID = currUID
		earliestLine=$0
		}
	}
	else if(stime ~ old && earliest ~old){
		stimeMonth=stime
		stimeDay=stime
		earliestMonth=earliest
		earliestDay=earliest
	
		sub("[A-Z][a-z][a-z]","",stimeDay)
		sub("[0-9][0-9]", "",stimeMonth)
		stimeConv=revMonths[stimeMonth] stimeDay
			
		sub("[A-Z][a-z][a-z]","",earliestDay)
		sub("[0-9][0-9]","",earliestMonth)
		earliestConv=revMonths[earliestMonth] earliestDay

		if(earliestConv > stimeConv ||(earliestConv == stimeConv && earliestUID > currUID)){
			earliest=stime
			earliestLine=$0		
			earliestUID = currUID
		}
	}
}

END{
print "\n"

print "Earliest" 
print earliestLine

print "Latest"
print latestLine
}
