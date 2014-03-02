i = 0
define f() {
	global i
	i = i + 1
	print i
	if i < 5 {
		f()
	}
}

f()