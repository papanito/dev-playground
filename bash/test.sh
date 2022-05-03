#!/bin/bash
directory="/tmp/*"
for f in $directory
do
    echo "Processing $f"
    # do something on $fa
    echo $f | awk '{if($0 !~ /^#/) print "chr"$0; else print $0}' no_chr.vcf > with_chr.vcf
done