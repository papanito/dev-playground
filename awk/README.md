# awk

Examples for awk.

```bash
# print 1 .. n for each number in numbers.txt
awk -f numbers.awk numbers.txt
```

```bash
# print filenames starting with z and it's size in KB
awk -f filename_size.awk ls_usr_bin.txt
```
