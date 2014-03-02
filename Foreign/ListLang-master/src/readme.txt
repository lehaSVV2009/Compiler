required: 
	python 2.7.x
	java

get help: 
	python listlang.py -h

compile example:
	python listlang.py examples\merge_sorted_lists.ll tmp\target.jar

run compiled example:
	java -jar tmp\target.jar