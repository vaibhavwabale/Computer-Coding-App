package in.icomputercoding.computercoding.Programs;

public class Programs {

    public static final String C1 = "" +
            "#include<stdio.h>\n" +
            "#define MAX_SIZE 100\n" +
            "int main()\n" +
            "{\n" +
            "\tchar text[MAX_SIZE];\n" +
            "\tchar * str = text;\n" +
            "\tint count = 0;\n" +
            "\tprintf('Enter any string : ');\n" +
            "\tgets(text);\n" +
            "\twhile(*(str++) != '\0') count++;\n" +
            "\tprintf('Length of '%s' = %d', text, count);\n" +
            "\treturn 0;\n" +
            "}\n";

    public static final String C2 = "" +
            "#include<stdio.h>\n" +
            "#include<stdlib.h>\n" +
            "int main()\n" +
            "{\n" +
            "int i, j, rows, cols, **a, **b, **result;\n" +
            "printf('Addition of two matrix ');\n" +
            "printf('Enter number of rows: ');\n" +
            "scanf('%d', &rows);\n" +
            "printf('Enter number of columns: ');\n" +
            "scanf('%d', &columns);\n" +
            "a=malloc(rows*sizeof(int*));\n" +
            "b=malloc(rows*sizeof(int*));\n" +
            "result=malloc(rows*sizeof(int*));\n" +
            "for(i=0;i<rows;i++)\n" +
            "{\n" +
            "a[i]=malloc(cols*sizeof(int));\n" +
            "b[i]=malloc(cols*sizeof(int));\n" +
            "result[row]=malloc(cols*sizeof(int));\n" +
            "}\n" +
            "for(i=0;i<rows;i++)\n" +
            "{\n" +
            "for(j=0;j<cols;j++)\n" +
            "{\n" +
            "printf('Enter Element %d %d: ',i,j);\n" +
            "scanf('%d',&a[i][j]);\n" +
            "}\n" +
            "}\n" +
            "for(i=0;i<rows;i++)\n" +
            "{\n" +
            "for(j=0;j<cols;j++)\n" +
            "{\n" +
            "printf('Enter Element %d %d: ',i,j);\n" +
            "scanf('%d',&b[i][j]);\n" +
            "}\n" +
            "}\n" +
            "for(i=0;i<rows;i++)\n" +
            "{\n" +
            "for(j=0;j<rows;j++)\n" +
            "{\n" +
            "result[i][j]=a[i][j]+b[i][j];\n" +
            "}\n" +
            "}\n" +
            "for(i=0;i<rows;i++)\n" +
            "{\n" +
            "for(j=0;j<cols;j++)\n" +
            "{\n" +
            "printf('%d',result[i][j]));\n" +
            "}\n" +
            "printf('/n');\n" +
            "}\n" +
            "return 0;\n" +
            "}\n";

    public static final String C3 = "" +
            "#include<stdio.h>\n" +
            "#define MAX_SIZE 100\n" +
            "int main()\n" +
            "{\n" +
            "char text[MAX_SIZE];\n" +
            "int i;\n" +
            "int count=0;\n" +
            "printf('Enter any string: ');\n" +
            "gets(text);\n" +
            "for(i=0; text[i]!='\0'; i++)\n" +
            "{\n" +
            "count++;\n" +
            "}\n" +
            "printf('length of '%s'= &d', text, count);\n" +
            "return 0;\n" +
            "}\n";

    public static final String C4 = "" +
            "#include<stdio.h>\n" +
            "int main()\n" +
            "{\n" +
            "char text[100];\n" +
            "int begin, middle, end, length = 0;\n" +
            "printf('Enter any string: ');\n" +
            "gets(text);\n" +
            "while(text[length]!='\0')\n" +
            "length++;\n" +
            "end = length-1;\n" +
            "middle = length/2;\n" +
            "for(begin=0;begin<middle;begin++)\n" +
            "{\n" +
            "if(text[begin]!=text[end])\n" +
            "{\n" +
            "printf{'Not a Palindrome.');\n" +
            "break;\n" +
            "}\n" +
            "end--;\n" +
            "}\n" +
            "if(begin==middle)\n" +
            "printf('Palindrome.');\n" +
            "return 0;\n" +
            "}\n";

    public static final String C5 = "" +
            "#include<stdio.h>\n" +
            "#define MAX_SIZE 100\n" +
            "int main()\n" +
            "{\n" +
            "char text1[MAX_SIZE];\n" +
            "char text2[MAX_SIZE];\n" +
            "int i;\n" +
            "printf('Enter any string: ');\n" +
            "gets(text1);\n" +
            "for(i=0;text1[i]!='0';i++)\n" +
            "{\n" +
            "text2[i]=text1[i];\n" +
            "}\n" +
            "text2[i]='\0';\n" +
            "printf('First String = %s ',text1);\n" +
            "printf('Second String = %s ',text2);\n" +
            "printf('Total Characters Copied = %d ',i);\n" +
            "return 0;\n" +
            "}\n";

    public static final String C6 = "" +
            "#include<stdio.h>\n" +
            "#define MAX_SIZE 100\n" +
            "int main()\n" +
            "{\n" +
            "char text1[MAX_SIZE];\n" +
            "char text2[MAX_SIZE];\n" +
            "char *str1=text1;\n" +
            "char *str2=text2;\n" +
            "printf('Enter any string: ');\n" +
            "gets(text1);\n" +
            "while(*(str2++)=*(str1++));\n" +
            "printf('First String = %s ',text1);\n" +
            "printf('Second String = %s ',text2);\n" +
            "return 0;\n" +
            "}\n";

    public static final String C7 = "" +
            "#include<stdio.h>\n" +
            "struct student\n" +
            "{\n" +
            "char name[30];\n" +
            "int RollNo;\n" +
            "struct dateOfBirth\n" +
            "{\n" +
            "int dd;\n" +
            "int mm;\n" +
            "int yy;\n" +
            "}\n" +
            "DOB;\n" +
            "};\n" +
            "int main()\n" +
            "{\n" +
            "struct student std;\n" +
            "printf('Enter Name: ');\n" +
            "gets(std.name);\n" +
            "printf('Enter Roll Number: ');\n" +
            "printf('Enter Date of Birth [DD-MM-YY]format: ');\n" +
            "scanf('%d%d%d', &std.DOB.dd, &std.DOB.mm, &std.DOB.yy);\n" +
            "printf('Name: %s RollNo: %d Date of birth: %02d%02d%02d ', std.name, std.rollNo, std.DOB.dd, std.DOB.mm, std.DOB.yy);\n" +
            "return 0;\n" +
            "}\n";

    public static final String C8 = "" +
            "#include<stdio.h>\n" +
            "int main()\n" +
            "{\n" +
            "char str[MAX_SIZE];\n" +
            "char*s=str;\n" +
            "printf('Enter your text: ');\n" +
            "gets(str)\n" +
            "while(*s)\n" +
            "{\n" +
            "*s=(*s>'a' && *s<='z')? *s-32:*s;\n" +
            "s++;\n" +
            "}\n" +
            "printf('Uppercase String: %s ',str);\n" +
            "return 0;\n" +
            "}\n";

    public static final String C9 = "" +
            "#include <stdio.h>\n" +
            "int main()\n" +
            "{\n" +
            "int num;\n" +
            "printf('Enter an integer: ');\n" +
            "scanf('%d', &num);\n" +
            "// true if num is perfectly divisible by 2\n" +
            "if(num % 2 == 0)\n" +
            "printf('%d is even.', num);\n" +
            "else\n" +
            "printf('%d is odd.', num);\n" +
            "return 0;\n" +
            "}\n";

    public static final String C10 = "" +
            "#include <stdio.h>\n" +
            "int main()\n" +
            "{\n" +
            "int lowercase_vowel, uppercase_vowel;\n" +
            "char c;\n" +
            "printf('Enter an alphabet: ');\n" +
            "scanf('%c', &c);\n" +
            "// evaluates to 1 if variable c is a lowercase vowel\n" +
            "lowercase_vowel = (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');\n" +
            "// evaluates to 1 if variable c is a uppercase vowel\n" +
            "uppercase_vowel = (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');\n" +
            "// evaluates to 1 (true) if c is a vowel\n" +
            "if (lowercase_vowel || uppercase_vowel)\n" +
            "printf('%c is a vowel.', c);\n" +
            "else\n" +
            "printf('%c is a consonant.', c);\n" +
            "return 0;\n" +
            "}\n";


    public static final String java1 = "" +
            "package icomputercoding;\n" +
            "import java.util.Scanner;\n" +
            "public class Calculator {\n" +
            "public static void main(String[] args) {\n" +
            "Scanner reader = new Scanner(System.in);\n" +
            "System.out.print('Enter two numbers: ');\n" +
            "//nextDouble() reads the next double from the keyboard\n" +
            "double first = reader.nextDouble();\n" +
            "double second = reader.nextDouble();\n" +
            "System.out.print('Enter an operator (+, -, *, /): ');\n" +
            "char operator = reader.next().charAt(0);\n" +
            "double result;\n" +
            "//switch case for each of the operations\n" +
            "switch(operator)\n" +
            "{\n" +
            "case '+':\n" +
            "result = first + second;\n" +
            "break;\n" +
            "case '-':\n" +
            "result = first - second;\n" +
            "break;\n" +
            "case '*':\n" +
            "result = first * second;\n" +
            "break;\n" +
            "case '/':\n" +
            "result = first / second;\n" +
            "break;\n" +
            "// operator doesn't match any case constant (+, -, *, /)\n" +
            "default:\n" +
            "System.out.printf('Error! operator is not correct');\n" +
            "return;\n" +
            "}\n" +
            "//printing the result of the operations\n" +
            "System.out.printf('%.1f %c %.1f = %.1f', first, operator, second, result);\n" +
            "}\n" +
            "}\n";


    public static final String java2 = "" +
            "package icomputercoding;\n" +
            "import java.util.Scanner;\n" +
            "public class Factorial {\n" +
            "public static void main(String args[]){\n" +
            "//Scanner object for capturing the user input\n" +
            "Scanner scanner = new Scanner(System.in);\n" +
            "System.out.println('Enter the number:');\n" +
            "//Stored the entered value in variable\n" +
            "int num = scanner.nextInt();\n" +
            "//Called the user defined function fact\n" +
            "int factorial = fact(num);\n" +
            "System.out.println('Factorial of entered number is: ' +factorial);\n" +
            "}\n" +
            "static int fact(int n)\n" +
            "{\n" +
            "int output;\n" +
            "if(n==1){\n" +
            "return 1;\n" +
            "}\n" +
            "//Recursion: Function calling itself!!\n" +
            "output = fact(n-1)* n;\n" +
            "return output;\n" +
            "}\n" +
            "}\n";


    public static final String java3 = "" +
            "package icomputercoding;\n" +
            "public class Fibonacci {\n" +
            "public static void main(String[] args) {\n" +
            "//initializing the constants\n" +
            "int n = 100, t1 = 0, t2 = 1;\n" +
            "System.out.print('Upto ' + n + ': ');\n" +
            "//while loop to calculate fibonacci series upto n numbers\n" +
            "while (t1<= n)\n" +
            "{\n" +
            "System.out.print(t1 + " + ");\n" +
            "int sum = t1 + t2;\n" +
            "t1 = t2;\n" +
            "t2 = sum;\n" +
            "}\n" +
            "}\n" +
            "}\n";

    public static final String java4 = "" +
            "package icomputercoding;\n" +
            "import java.util.Scanner;\n" +
            "public class Palindrome {\n" +
            "static void checkPalindrome(String input) {\n" +
            "//Assuming result to be true\n" +
            "boolean res = true;\n" +
            "int length = input.length();\n" +
            "//dividing the length of the string by 2 and comparing it.\n" +
            "for(int i=0; i<= length/2; i++) {\n" +
            "if(input.charAt(i) != input.charAt(length-i-1)) {\n" +
            "res = false;\n" +
            "break;\n" +
            "}\n" +
            "}\n" +
            "System.out.println(input + ' is palindrome = ' +res);\n" +
            "}\n" +
            "public static void main(String[] args) {\n" +
            "Scanner sc = new Scanner(System.in);\n" +
            "System.out.print('Enter your Statement: ');\n" +
            "String str = sc.nextLine();\n" +
            "//function call\n" +
            "checkPalindrome(str);\n" +
            "}\n" +
            "}\n";

    public static final String java5 = "" +
            "package icomputercoding;\n" +
            "import java.util.Scanner;\n" +
            "public class nprandncr {\n" +
            "//calculating a factorial of a number\n" +
            "public static int fact(int num)\n" +
            "{\n" +
            "int fact=1, i;\n" +
            "for(i=1; i<=num; i++)\n" +
            "{\n" +
            "fact = fact*i;\n" +
            "}\n" +
            "return fact;\n" +
            "}\n" +
            "public static void main(String args[])\n" +
            "{\n" +
            "int n, r;\n" +
            "Scanner scan = new Scanner(System.in);\n" +
            "System.out.print('Enter Value of n : ');\n" +
            "n = scan.nextInt();\n" +
            "System.out.print('Enter Value of r : ');\n" +
            "r = scan.nextInt();\n" +
            "// NCR and NPR of a number\n" +
            "System.out.print('NCR = ' +(fact(n)/(fact(n-r)*fact(r))));\n" +
            "System.out.print('nNPR = ' +(fact(n)/(fact(n-r))));\n" +
            "}\n" +
            "}\n";


    public static final String java6 = "" +
            "package icomputercoding;\n" +
            "public class stringreverse {\n" +
            "public static void main(String[] args) {\n" +
            "// TODO Auto-generated method stub\n" +
            "String str = 'Welcome To Computer Coding';\n" +
            "String[] strArray = str.split(' ');\n" +
            "for (String temp: strArray){\n" +
            "System.out.println(temp);\n" +
            "}\n" +
            "for(int i=0; i<3; i++){ char[] s1 = strArray[i].toCharArray(); for (int j = s1.length-1; j>=0; j--)\n" +
            "{\n" +
            "System.out.print(s1[j]);\n" +
            "}\n" +
            "System.out.print(' ');\n" +
            "}\n" +
            "}\n" +
            "}\n";

    public static final String java7 = "" +
            "package icomputercoding;\n" +
            "//Java implementation of the approach\n" +
            "public class MirrorInverse {\n" +
            "// Function that returns true if\n" +
            "// the array is mirror-inverse\n" +
            "static boolean isMirrorInverse(int arr[])\n" +
            "{\n" +
            "for (int i = 0; i<arr.length; i++) {\n" +
            "// If condition fails for any element\n" +
            "if (arr[arr[i]] != i)\n" +
            "return false;\n" +
            "}\n" +
            "// Given array is mirror-inverse\n" +
            "return true;\n" +
            "}\n" +
            "public static void main(String[] args)\n" +
            "{\n" +
            "int arr[] = { 1, 2, 3, 0 };\n" +
            "if (isMirrorInverse(arr))\n" +
            "System.out.println('Yes');\n" +
            "else\n" +
            "System.out.println('No');\n" +
            "}\n" +
            "}\n";

    public static final String java8 = "" +
            "package icomputercoding;\n" +
            "public class BinarySearch {\n" +
            "int binarySearch(int arr[], int l, int r, int x)\n" +
            "{\n" +
            "if (r >= l) {\n" +
            "int mid = l + (r - l) / 2;\n" +
            "if (arr[mid] == x)\n" +
            "return mid;\n" +
            "if (arr[mid] >x)\n" +
            "return binarySearch(arr, l, mid - 1, x);\n" +
            "return binarySearch(arr, mid + 1, r, x);\n" +
            "}\n" +
            "return -1;\n" +
            "}\n" +
            "public static void main(String args[])\n" +
            "{\n" +
            "BinarySearch ob = new BinarySearch();\n" +
            "int arr[] = { 2, 3, 4, 10, 40 };\n" +
            "int n = arr.length;\n" +
            "int x = 40;\n" +
            "int result = ob.binarySearch(arr, 0, n - 1, x);\n" +
            "if (result == -1)\n" +
            "System.out.println('Element not present');\n" +
            "else\n" +
            "System.out.println('Element found at index ' + result);\n" +
            "}\n" +
            "}\n";


    public static final String java9 = "" +
            "package icomputercoding;\n" +
            "import java.sql.*;\n" +
            "import java.sql.DriverManager;\n" +
            "public class Example {\n" +
            "// JDBC driver name and database URL\n" +
            "static final String JDBC_DRIVER = 'com.mysql.jdbc.Driver';\n" +
            "static final String DB_URL = 'jdbc:mysql://localhost/emp';\n" +
            "// Database credentials\n" +
            "static final String USER = 'root';\n" +
            "static final String PASS = 'icomputercoding';\n" +
            "public static void main(String[] args) {\n" +
            "Connection conn = null;\n" +
            "Statement stmt = null;\n" +
            "try{\n" +
            "//STEP 2: Register JDBC driver\n" +
            "Class.forName('com.mysql.cj.jdbc.Driver');\n" +
            "//STEP 3: Open a connection\n" +
            "System.out.println('Connecting to database...');\n" +
            "conn = DriverManager.getConnection(DB_URL,'root','icomputercoding');\n" +
            "//STEP 4: Execute a query\n" +
            "System.out.println('Creating statement...');\n" +
            "stmt = conn.createStatement();\n" +
            "String sql;\n" +
            "sql = 'SELECT id, first, last, age FROM Employees';\n" +
            "ResultSet rs = stmt.executeQuery(sql);\n" +
            "//STEP 5: Extract data from result set\n" +
            "while(rs.next()){\n" +
            "//Retrieve by column name\n" +
            "int id = rs.getInt('id');\n" +
            "int age = rs.getInt('age');\n" +
            "String first = rs.getString('first');\n" +
            "String last = rs.getString('last');\n" +
            "//Display values\n" +
            "System.out.print('ID: ' + id);\n" +
            "System.out.print(', Age: ' + age);\n" +
            "System.out.print(', First: ' + first);\n" +
            "System.out.println(', Last: ' + last);\n" +
            "}\n" +
            "//STEP 6: Clean-up environment\n" +
            "rs.close();\n" +
            "stmt.close();\n" +
            "conn.close();\n" +
            "}catch(SQLException se){\n" +
            "//Handle errors for JDBC\n" +
            "se.printStackTrace();\n" +
            "}catch(Exception e){\n" +
            "//Handle errors for Class.forName\n" +
            "e.printStackTrace();\n" +
            "}finally{\n" +
            "//finally block used to close resources\n" +
            "try{\n" +
            "if(stmt!=null)\n" +
            "stmt.close();\n" +
            "}catch(SQLException se2){\n" +
            "}// nothing can be done\n" +
            "try{\n" +
            "if(conn!=null)\n" +
            "conn.close();\n" +
            "}catch(SQLException se){\n" +
            "se.printStackTrace();\n" +
            "}//end finally try\n" +
            "}//end try\n" +
            "System.out.println('Goodbye!');\n" +
            "}//end main\n" +
            "} // end Example\n";

    public static final String java10 = "" +
            "package icomputercoding;\n" +
            "import java.util.ArrayList;\n" +
            "import java.util.List;\n" +
            "import java.util.function.Predicate;\n" +
            "public class ArrayListExample {\n" +
            "public static void main(String[] args) {\n" +
            "List<String> programmingLanguages = new ArrayList<>();\n" +
            "programmingLanguages.add('C');\n" +
            "programmingLanguages.add('C++');\n" +
            "programmingLanguages.add('Java');\n" +
            "programmingLanguages.add('Kotlin');\n" +
            "programmingLanguages.add('Python');\n" +
            "programmingLanguages.add('Perl');\n" +
            "programmingLanguages.add('Ruby');\n" +
            "System.out.println('Initial List: ' + programmingLanguages);\n" +
            "// Remove the element at index `5`\n" +
            "programmingLanguages.remove(5);\n" +
            "System.out.println('After remove(5): ' + programmingLanguages);\n" +
            "// Remove the first occurrence of the given element from the ArrayList\n" +
            "// (The remove() method returns false if the element does not exist in the ArrayList)\n" +
            "boolean isRemoved = programmingLanguages.remove('Kotlin');\n" +
            "System.out.println('After remove('Kotlin'): ' + programmingLanguages);\n" +
            "// Remove all the elements that exist in a given collection\n" +
            "List<String> scriptingLanguages = new ArrayList<>();\n" +
            "scriptingLanguages.add('Python');\n" +
            "scriptingLanguages.add('Ruby');\n" +
            "scriptingLanguages.add('Perl');\n" +
            "programmingLanguages.removeAll(scriptingLanguages);\n" +
            "System.out.println('After removeAll(scriptingLanguages): ' + programmingLanguages);\n" +
            "// Remove all the elements that satisfy the given predicate\n" +
            "programmingLanguages.removeIf(new Predicate<String>() {\n" +
            "@Override\n" +
            "public boolean test(String s) {\n" +
            "return s.startsWith('C');\n" +
            "}\n" +
            "});\n" +
            "System.out.println('After Removing all elements that start with 'C': ' + programmingLanguages);\n" +
            "// Remove all elements from the ArrayList\n" +
            "programmingLanguages.clear();\n" +
            "System.out.println('After clear(): ' + programmingLanguages);\n" +
            "}\n" +
            "}\n";


    public static final String CPP1 = "" +
            "#include <iostream.h>\n" +
            "using namespace std;\n" +
            "int main() {\n" +
            "int n;\n" +
            "cout << 'Enter an integer: ';\n" +
            "cin >> n;\n" +
            "if ( n % 2 == 0)\n" +
            "cout << n << ' is even.';\n" +
            "else\n" +
            "cout << n << ' is odd.';\n" +
            "return 0;\n" +
            "}\n";

    public static final String CPP2 = "" +
            "#include <iostream.h>\n" +
            "using namespace std;\n" +
            "int main() {\n" +
            "int n, reversedNumber = 0, remainder;\n" +
            "cout << 'Enter an integer: ';\n" +
            "cin >> n;\n" +
            "while(n != 0) {\n" +
            "remainder = n%10;\n" +
            "reversedNumber = reversedNumber*10 + remainder;\n" +
            "n /= 10;\n" +
            "}\n" +
            "cout << 'Reversed Number = ' << reversedNumber;\n" +
            "return 0;\n" +
            "}\n";

    public static final String CPP3 = "" +
            "#include <iostream.h>\n" +
            "using namespace std;\n" +
            "int main()\n" +
            "{\n" +
            "int n, t1 = 0, t2 = 1, nextTerm = 0;\n" +
            "cout << 'Enter the number of terms: ';\n" +
            "cin >> n;\n" +
            "cout << 'Fibonacci Series: ';\n" +
            "for (int i = 1; i <= n; ++i)\n" +
            "{\n" +
            "// Prints the first two terms.\n" +
            "if(i == 1)\n" +
            "{\n" +
            "cout << ' ' << t1;\n" +
            "continue;\n" +
            "}\n" +
            "if(i == 2)\n" +
            "{\n" +
            "cout << t2 << ' ';\n" +
            "continue;\n" +
            "}\n" +
            "nextTerm = t1 + t2;\n" +
            "t1 = t2;\n" +
            "t2 = nextTerm;\n" +
            "cout << nextTerm << ' ';\n" +
            "}\n" +
            "return 0;\n" +
            "}\n";

    public static final String CPP4 = "" +
            "#include <iostream>\n" +
            "using namespace std;\n" +
            "int main()\n" +
            "{\n" +
            "int year;\n" +
            "cout << 'Enter a year: ';\n" +
            "cin >> year;\n" +
            "if (year % 4 == 0)\n" +
            "{\n" +
            "if (year % 100 == 0)\n" +
            "{\n" +
            "if (year % 400 == 0)\n" +
            "cout << year << ' is a leap year.';\n" +
            "else\n" +
            "cout << year << ' is not a leap year.';\n" +
            "}\n" +
            "else\n" +
            "cout << year << ' is a leap year.';\n" +
            "}\n" +
            "else\n" +
            "cout << year << ' is not a leap year.';\n" +
            "return 0;\n" +
            "}\n";

    public static final String CPP5 = "" +
            "#include <iostream>\n" +
            "using namespace std;\n" +
            "int main()\n" +
            "{\n" +
            "int n, range;\n" +
            "cout << 'Enter an integer: ';\n" +
            "cin >> n;\n" +
            "cout << 'Enter range: ';\n" +
            "cin >> range;\n" +
            "for (int i = 1; i <= range; ++i) {\n" +
            "cout << n << ' * ' << i << ' = ' << n * i << endl;\n" +
            "}\n" +
            "return 0;\n" +
            "}\n";

    public static final String CPP6 = "" +
            "#include <iostream>\n" +
            "using namespace std;\n" +
            "void quick_sort(int[], int, int); \n" +
            "int partition(int[], int, int);\n" +
            "int main() {\n" +
            "int a[ 50],n, i;\n" +
            "cout << 'Enter size of Array : ';\n" +
            "cin >> n;\n" +
            "cout << 'Enter elements to the array : ';\n" +
            "for (i = 0; i < n; ++i) {\n" +
            "cout << 'Enter ' << i + 1 << ' element : ';\n" +
            "cin >> a[i];\n" +
            "}\n" +
            "quick_sort(a, 0, n - 1);\n" +
            "cout << 'After Quick Sort, Sorted List is : ';\n" +
            "for (i = 0; i < n; i++) {\n" +
            "cout << a[i] << '  ';\n" +
            "}\n" +
            "cout << ' ';\n" +
            "return 0;\n" +
            "}\n" +
            "void quick_sort(int a[], int l, int u) {\n" +
            "int j;\n" +
            "if (l < u) {\n" +
            "j = partition(a, l, u);\n" +
            "quick_sort(a, l, j - 1);\n" +
            "quick_sort(a, j + 1, u);\n" +
            "}\n" +
            "}\n" +
            "int partition(int a[], int l, int u) {\n" +
            "int v, i, j, temp;\n" +
            "v = a[l];\n" +
            "i = l;\n" +
            "j = u + 1;\n" +
            "do {\n" +
            "do\n" +
            "i++;\n" +
            "while (a[i] < v && i <= u);\n" +
            "do\n" +
            "j--;\n" +
            "while (v < a[j]);\n" +
            "if (i < j) {\n" +
            "temp = a[i];\n" +
            "a[i] = a[j];\n" +
            "a[j] = temp;\n" +
            "}\n" +
            "} while (i < j);\n" +
            "a[l] = a[j];\n" +
            "a[j] = v;\n" +
            "return (j);\n" +
            "}\n";

    public static final String CPP7 = "" +
            "#include<iostream>\n" +
            "using namespace std;\n" +
            "void swap(int &,int &);\n" +
            "int main()\n" +
            "{\n" +
            "int a,b;\n" +
            "cout<<'Enter Value Of A : ';\n" +
            "cin>>a;\n" +
            "cout<<'Enter Value of B : ';\n" +
            "cin>>b;\n" +
            "cout<<'Before Swapping, Value of : A = '<<a<<'B = '<<b<<' ';\n" +
            "swap(a,b);\n" +
            "cout<<'Outside Function After Swapping, Value of : A = '<<a<<'B = '<<b<<' ';\n" +
            "}\n" +
            "void swap(int &a,int &b)\n" +
            "{\n" +
            "int c;\n" +
            "c=a;\n" +
            "a=b;\n" +
            "b=c;\n" +
            "cout<<'Inside Function After Swapping, Value of : A = '<<a<<' B = '<<b<<' ';\n" +
            "}\n";


    public static final String CPP8 = "" +
            "#include<iostream>\n" +
            "using namespace std;\n" +
            "class cube\n" +
            "{\n" +
            "public:\n" +
            "double side;\n" +
            "double volume()\n" +
            "{\n" +
            "return(side*side*side);\n" +
            "}\n" +
            "cube(double side1)\n" +
            "{\n" +
            "cout << ' A constructor is called ' << endl;\n" +
            "side=side1;\n" +
            "}\n" +
            "cube()\n" +
            "{\n" +
            "cout << ' A default constructor is called ' << endl;\n" +
            "}\n" +
            "~cube()\n" +
            "{\n" +
            "cout << ' Destructing ' << side << endl;\n" +
            "}\n" +
            "};\n" +
            "int main()\n" +
            "{\n" +
            "cube c1(2.34);\n" +
            "cube c2;\n" +
            "cout << ' The side of the cube is: ' << c1.side << endl;\n" +
            "cout << ' The volume of the first cube is : ' << c1.volume() << endl;\n" +
            "cout << ' Enter the length of the second cube : ' ;\n" +
            "cin >> c2.side;\n" +
            "cout << ' The volume of second cube is : ' << c2.volume() << endl;\n" +
            "return(0);\n" +
            "}\n";

    public static final String CPP9 = "" +
            "#include<iostream>\n" +
            "#include<stdio.h>\n" +
            "#include<fstream>\n" +
            "#include<iomanip>\n" +
            "#include<string.h>\n" +
            "using namespace std;\n" +
            "int menu();\n" +
            "class Book\n" +
            "{\n" +
            "private:\n" +
            "int bookid;\n" +
            "char title[20];\n" +
            "float price;\n" +
            "protected:\n" +
            "int allotbookid();\n" +
            "void showheader();\n" +
            "public:\n" +
            "void getbook();\n" +
            "void showbook();\n" +
            "void addbook();\n" +
            "void viewbook();\n" +
            "void searchbook();\n" +
            "void deletebook();\n" +
            "void modifybook();\n" +
            "};\n" +
            "int Book::allotbookid()\n" +
            "{\n" +
            "ifstream fin;\n" +
            "Book temp;\n" +
            "int id=0;\n" +
            "fin.open('C:\\Users\\acer\\Documents\\books.txt',ios::in|ios::binary);\n" +
            "if(!fin)\n" +
            "return(id+1);\n" +
            "else\n" +
            "{\n" +
            "fin.read((char*)&temp,sizeof(temp));\n" +
            "while(!fin.eof())\n" +
            "{\n" +
            "id=temp.bookid;\n" +
            "fin.read((char*)&temp,sizeof(temp));\n" +
            "}\n" +
            "id++;\n" +
            "return(id);\n" +
            "}\n" +
            "}\n" +
            "void Book::showheader()\n" +
            "{\n" +
            "cout<<left;\n" +
            "cout<<' '<<setw(10)<<' BOOK ID '<<setw(10)<<'Price'<<setw(10)<<'Title ';\n" +
            "}\n" +
            "void Book::getbook()\n" +
            "{\n" +
            "cout<<'Enter Book Title: ';\n" +
            "fflush(stdin);\n" +
            "gets(title);\n" +
            "cout<<' Price of Book: ';\n" +
            "cin>>price;\n" +
            "bookid=allotbookid();\n" +
            "}\n" +
            "void Book::showbook()\n" +
            "{\n" +
            "cout<<left;\n" +
            "cout<<' '<<setw(10)<<bookid<<setw(10)<<price<<setw(10)<<title;\n" +
            "}\n" +
            "void Book::addbook()\n" +
            "{\n" +
            "ofstream fout;\n" +
            "fout.open('C:\\Users\\acer\\Documents\\books.txt',ios::out|ios::app|ios::binary);\n" +
            "if(!fout)\n" +
            "cout<<' File can not open';\n" +
            "else\n" +
            "fout.write((char*)this,sizeof(*this));\n" +
            "fout.close();\n" +
            "}\n" +
            "void Book::viewbook()\n" +
            "{\n" +
            "ifstream fin;\n" +
            "fin.open('C:\\Users\\acer\\Documents\\books.txt',ios::in|ios::binary);\n" +
            "if(!fin)\n" +
            "cout<<' File not found';\n" +
            "else\n" +
            "{\n" +
            "showheader();\n" +
            "fin.read((char*)this,sizeof(*this));\n" +
            "while(!fin.eof())\n" +
            "{\n" +
            "showbook();\n" +
            "fin.read((char*)this,sizeof(*this));\n" +
            "}\n" +
            "}\n" +
            "fin.close();\n" +
            "}\n" +
            "void Book::searchbook()\n" +
            "{\n" +
            "ifstream fin;\n" +
            "char str[20];\n" +
            "fin.open('C:\\Users\\acer\\Documents\\books.txt',ios::in|ios::binary);\n" +
            "cout<<'Enter the name of book to search:';\n" +
            "fflush(stdin);\n" +
            "gets(str);\n" +
            "if(!fin)\n" +
            "cout<<'File not found';\n" +
            "else\n" +
            "{\n" +
            "fin.read((char*)this,sizeof(*this));\n" +
            "while(!fin.eof())\n" +
            "{\n" +
            "if(!strcmp(this->title,str))\n" +
            "{\n" +
            "showheader();\n" +
            "showbook();\n" +
            "break;\n" +
            "}\n" +
            "fin.read((char*)this,sizeof(*this));\n" +
            "}\n" +
            "if(fin.eof())\n" +
            "cout<<' Record not found';\n" +
            "}\n" +
            "fin.close();\n" +
            "}\n" +
            "void Book:: modifybook()\n" +
            "{\n" +
            "int id,r=0;\n" +
            "fstream file;\n" +
            "file.open(' C:\\Users\\acer\\Documents\\books.txt',ios::in|ios::out|ios::ate|ios::binary);\n" +
            "cout<<' Enter record number to modify (bookid): ';\n" +
            "cin>>id;\n" +
            "file.seekg(0);\n" +
            "if(!file)\n" +
            "cout<<'File not found';\n" +
            "else\n" +
            "{\n" +
            "file.read((char*)this,sizeof(*this));\n" +
            "while(!file.eof())\n" +
            "{\n" +
            "r++;\n" +
            "if(bookid==id)\n" +
            "{\n" +
            "showheader();\n" +
            "showbook();\n" +
            "cout<<' Re-enter book details: ';\n" +
            "cout<<' Enter book title: ';\n" +
            "fflush(stdin);\n" +
            "gets(title);\n" +
            "cout<<' Enter book price';\n" +
            "cin>>price;\n" +
            "file.seekp((r-1)*sizeof(Book),ios::beg);\n" +
            "file.write((char*)this,sizeof(*this));\n" +
            "break;\n" +
            "}\n" +
            "file.read((char*)this,sizeof(*this));\n" +
            "}\n" +
            "if(file.eof())\n" +
            "cout<<'Record not found';\n" +
            "}\n" +
            "file.close();\n" +
            "}\n" +
            "void Book:: deletebook()\n" +
            "{\n" +
            "ifstream fin;\n" +
            "ofstream fout;\n" +
            "int id;\n" +
            "char x;\n" +
            "fin.open('C:\\Users\\acer\\Documents\\books.txt',ios::in|ios::binary);\n" +
            "fout.open('C:\\Users\\acer\\Documents\\tempbooks.txt',ios::out|ios::app|ios::binary);\n" +
            "cout<<'Enter bookid to delete record';\n" +
            "cin>>id;\n" +
            "if(!fin)\n" +
            "cout<<' File not found';\n" +
            "else\n" +
            "{\n" +
            "fin.read((char*)this,sizeof(*this));\n" +
            "while(!fin.eof())\n" +
            "{\n" +
            "if(this->bookid==id)\n" +
            "{\n" +
            "cout<<' Record you want to delete is: ';\n" +
            "showheader();\n" +
            "showbook();\n" +
            "cout<<' Are you sure you want to delete this record(y/n): ';\n" +
            "fflush(stdin);\n" +
            "cin>>x;\n" +
            "if(x=='n')\n" +
            "fout.write((char*)this,sizeof(*this));\n" +
            "else\n" +
            "cout<<' Record is deleted';\n" +
            "}\n" +
            "else\n" +
            "fout.write((char*)this,sizeof(*this));\n" +
            "fin.read((char*)this,sizeof(*this));\n" +
            "}\n" +
            "fin.close();\n" +
            "fout.close();\n" +
            "system('erase C:\\Users\\acer\\Documents\\books.txt');\n" +
            "system('rename C:\\Users\\acer\\Documents\\tempbooks.txt C:\\Users\\acer\\Documents\\books.txt');\n" +
            "}\n" +
            "}\n" +
            "int menu()\n" +
            "{\n" +
            "system('cls');\n" +
            "cout<<'1. Add new book';\n" +
            "cout<<'2. View all books';\n" +
            "cout<<'3. Search book';\n" +
            "cout<<'4. modify book';\n" +
            "cout<<'5. delete book';\n" +
            "cout<<'6. Exit';\n" +
            "cout<<'Enter your choice';\n" +
            "int ch;\n" +
            "cin>>ch;\n" +
            "return(ch);\n" +
            "}\n" +
            "int main()\n" +
            "{\n" +
            "Book b;\n" +
            "int ch;\n" +
            "while(1)\n" +
            "{\n" +
            "ch=menu();\n" +
            "switch(ch)\n" +
            "{\n" +
            "case 1:\n" +
            "b.getbook();\n" +
            "b.addbook();\n" +
            "break;\n" +
            "case 2:\n" +
            "b.viewbook();\n" +
            "break;\n" +
            "case 3:\n" +
            "b.searchbook();\n" +
            "break;\n" +
            "case 4:\n" +
            "b.modifybook();\n" +
            "break;\n" +
            "case 5:\n" +
            "b.deletebook();\n" +
            "break;\n" +
            "case 6:\n" +
            "exit(0);\n" +
            "default:\n" +
            "cout<<'Enter Valid choice';\n" +
            "}\n" +
            "}\n" +
            "return 0;\n" +
            "}\n";


    public static final String CPP10 = "" +
            "#include <iostream>\n" +
            "using namespace std;\n" +
            "template<class t1,class t2>\n" +
            "void sum(t1 a,t2 b) // defining template function\n" +
            "{\n" +
            "cout<<'Sum : '<<a+b<<endl;\n" +
            "}\n" +
            "int main()\n" +
            "{\n" +
            "int a,b;\n" +
            "float x,y;\n" +
            "cout<<' Enter two integer data:';\n" +
            "cin>>a>>b;\n" +
            "cout<<' Enter two float data:';\n" +
            "cin>>x>>y;\n" +
            "sum(a,b); // adding two integer type data\n" +
            "sum(x,y); // adding two float type data\n" +
            "sum(a,x); // adding a float and integer type data\n" +
            "return 0;\n" +
            "}\n";


}



