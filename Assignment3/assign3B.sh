
awk '$1 ~/[a-z]{3}[0-9]{3}/' - | sort | awk -f assign3B.awk -


