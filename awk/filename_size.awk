func round(n) {
    n = n/1024 + 0.5
    n = int(n)
    return n
}

$9 ~ /^z/ {print $9"\t"$5"\t"round($5)"K"}