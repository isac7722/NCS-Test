import { useNavigation } from "@react-navigation/native";
import { Button, Image, View } from "react-native";

export const ToDoDetailScreen = ({ route }) => {
    const { item } = route.params;
    const navigation = useNavigation();

    const handleGoBack = () => {
        navigation.goBack(); 
    };

    const handleNewToDo = () => {
      navigation.navigate("새 일기");
    }

    return (
        <View>
            <Image source={item.image} />
            <Text>Name: {item.name}</Text>
            <Button onPress={handleNewToDo}>등록하기</Button>
            <Button onPress={handleGoBack}>뒤로가기</Button>
        </View>
    )
}