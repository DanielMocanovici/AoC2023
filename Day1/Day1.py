class Day1:

    def lineNumberOne(self, line: str) -> int:
        start = 0
        end = len(line) - 1
        sum = ""

        while start <= end:
            if line[start].isnumeric():
                sum += line[start]
                break
            start += 1
        
        while end >= 0:
            if line[end].isnumeric():
                sum += line[end]
                break
            end -= 1

        return int(sum)
    
    def lineNumberTwo(self, line: str, digitMap) -> int:
        start = 0
        end = len(line) - 1
        sum = ""
        while start <= end:
            if line[start].isnumeric():
                sum += line[start]
                break
            elif start <= end - 2 and line[start:start + 3] in digitMap:
                sum += digitMap[line[start:start+3]]
                break
            elif start <= end - 3 and line[start:start + 4] in digitMap:
                sum += digitMap[line[start:start+4]]
                break
            elif start <= end - 4 and line[start:start + 5] in digitMap:
                sum += digitMap[line[start:start+5]]
                break
            start += 1
        
        while end >= 0:
            if line[end].isnumeric():
                sum += line[end]
                break
            elif end >= 2 and line[end -2: end + 1] in digitMap:
                sum += digitMap[line[end-2:end + 1]]
                break
            elif end >= 3 and line[end -3: end + 1] in digitMap:
                sum += digitMap[line[end-3:end + 1]]
                break
            elif end >= 4 and line[end -4: end + 1] in digitMap:
                sum += digitMap[line[end-4:end + 1]]
                break
            end -= 1

        return int(sum)

    def readFile(self, file):
        digitalMap = {
            "one" : "1", 
            "two" : "2", 
            "three" : "3", 
            "four" : "4", 
            "five" : "5", 
            "six" : "6", 
            "seven" : "7", 
            "eight" : "8", 
            "nine" : "9"
            } 
        sum = 0 
        for line in file:
            sum += self.lineNumberTwo(line, digitMap=digitalMap) 
        return sum


if __name__ == '__main__':
    currentFile = open(r"C:\Users\User\Desktop\MyGit\AdventCodeCalendar\Day1\Day1.txt", "r")
    print(Day1().readFile(currentFile))
    currentFile.close()