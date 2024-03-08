import { createNativeStackNavigator } from "@react-navigation/native-stack"

export const MyToDoStack = () => {

    const Stack = createNativeStackNavigator();

    return (
        <Stack.Navigator
        initialRouteName = 'MyToDo'>

            <Stack.Screen
                name="MyToDo"
                component={MyToDoScreen}
            />

            <Stack.Screen
                name="ToDoDetail"
                component={ToDoDetailScreen}
            />
        </Stack.Navigator>
    )
}