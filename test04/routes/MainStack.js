import { createBottomTabNavigator } from "@react-navigation/bottom-tabs"
import { MainScreen } from "../screens/MainScreen";


export const MainStack = () => {

    const Tab = createBottomTabNavigator();

    return (
        <Tab.Navigator>

            <Tab.Screen
                name="메인페이지"
                component={MainScreen}
            />

            <Tab.Screen
                name="나의 일기"
                component={MyToDoStack}
            />

            <Tab.Screen
                name="새 일기"
                component={NewToDoScreen}
            />
        </Tab.Navigator>
    )
}