#!/bin/bash

total=0

for total in $( cd ./data/ && ls *.crs | wc -l); do
	echo "Total course records: $total"
done
