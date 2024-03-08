import { View } from "react-native"
import { useStore } from "zustand"
import { useToDoList } from "../zustand/useToDolist"
import { ToDoListCard } from "../item/ToDoListCard";

export const MyToDoScreen = () => {

    const { toDolist, fetchToDoList } = useStore(useToDoList);

    useEffect(() => {
        fetchToDoList();
    }, []);

    return (
        <View>
            {toDolist && (
                <>
                    <FlatList
                        data={toDolist}
                        renderItem={({ item }) => <ToDoListCard todoList={item} />}
                        keyExtractor={(item) => item.name}
                    />
                </>
            )}
        </View>
    )
}



