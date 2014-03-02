define quickSort(List l) {
	
	if not l {
		return []
	}
	
	pivot = l[0]
	
	low = []
	high = []
	if len(l) > 1 {
		for x in l[1:len(l)] {
			if x < pivot {
				low = low + x
			} else {
				high = high + x
			}
		}
	}
	
	lesser = quickSort(low)	
	greater = quickSort(high)
	
	return lesser + [pivot] + greater	
}

l = [6, 4, 8, 8, 1, 4, 6, 3, 5, 1]

print quickSort(l) == [1, 1, 3, 4, 4, 5, 6, 6, 8, 8]
