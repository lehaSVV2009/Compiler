define reverse(List l) {
	result = []
	while l {
		result = l[0] + result
		--l
	}
	return result
}

list = [1, 2, 3, 4, 5]

print reverse(list) == [5, 4, 3, 2, 1]
