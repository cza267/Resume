#sed script

#driver's license

s/([A-Z]{2}DL) [0-9]+/\1 XXXXXX/g

#credit card 
	#Visa
s/(4[0-9]{11}([0-9]{4}))|(4[0-9]{3}-[0-9]{4}-[0-9]{4}-([0-9]{4}))/VISA-\2\4/g

	#Master
s/(5[0-9]{3}-[0-9]{4}-[0-9]{4}-([0-9]{4}))|(5[0-9]{3}[0-9]{4}[0-9]{4}([0-9]{4}))/MC-\2\4/g

  #Discover
s/(6[0-9]{3}-[0-9]{4}-[0-9]{4}-([0-9]{4}))|(6[0-9]{3}[0-9]{4}[0-9]{4}([0-9]{4}))/DISC-\2\4/g

  #American Express
s/(3[47][0-9]{2}-[0-9]{6}-([0-9]{5}))|(3[47][0-9]{2}[0-9]{6}([0-9]{5}))/AMEX-\2\4/g
	
#Texas vehicle plate number
	#Type I
s/(TX)\ *[A-Z]{3}-*[0-9]{4}/\1 XXXXXX/g

	#Type II
s/(TX)\ *[0-9A-Z]{3}-*[0-9A-Z]{3}/\1 XXXXXX/g

#current date insertion
#use bash to invoke sed one liner

#municipality name insert
s/<orgname>/City of Gainsville, Florida/g

