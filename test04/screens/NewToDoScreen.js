
export const NewToDoScreen = () => {
    const [newToDoText, setNewToDoText] = useState(""); // State to hold new ToDo text

    const handleSaveToDo = () => {
      // Implement logic to save the new ToDo item (e.g., call API, store locally)
      console.log("New ToDo:", newToDoText); // For demonstration purposes
      // ... (Clear input or navigate back to ToDo list after saving)
    };
  
    return (
      <View>
        <TextInput
          value={newToDoText}
          onChangeText={setNewToDoText}
          placeholder="새로운 할 일 입력"
        />
        <Button title="저장" onPress={handleSaveToDo} />
      </View>
    );
}