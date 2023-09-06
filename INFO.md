## To make Coderunner work with java
1. Enter vsCode settings and find `Coderunner: Executor Map`
2. Click "edit in settings.json"
3. Find java
```json
"code-runner.executorMap": {
  "java": "cd $dir && javac $fileName && java $fileNameWithoutExt",
 }
```
4. Add `.java` to the end
```json
"code-runner.executorMap": {
  "java": "cd $dir && javac $fileName && java $fileNameWithoutExt.java",
 }
```
5. You  are now good to go!