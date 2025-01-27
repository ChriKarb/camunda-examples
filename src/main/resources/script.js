print("returnValueUserObj.stringify within script.js ::" + JSON.stringify(returnValueUserObj));

print("userObj3.stringify within script.js ::" + JSON.stringify(userObj3));

print("userObjVariableFromExecution.stringify within script.js ::" + JSON.stringify(userObjVariableFromExecution));
print("userObjVariableFromExecution.stringify from execution within script.js ::" + JSON.stringify(execution.getVariable('userObjVariableFromExecution')));


var userObj1 = {
    id: 1,
    name: "JSname"

}



print("userObj1 ::" + userObj1.name);
print("userObj1.stringify ::" + JSON.stringify(userObj1));


