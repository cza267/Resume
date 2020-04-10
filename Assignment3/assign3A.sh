
awk 'first=$1, last=$2 {print $2, $1}' $1 | sort #| awk '{ print $2,$1}' 


