ls -ltr

cd reports

rm -rf test-reports*

ls -ltr

cd ..

mvn clean

ls -ltr

git status

git add .

git status

foo="changes-"$(date +%Y-%m-%d-%H-%M-%S)

git commit -m $foo

git push