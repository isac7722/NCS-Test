import { useNavigation } from '@react-navigation/native';
import React, { useState } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, Button } from 'react-native';

export const ToDoListCard = ({ item }) => {
  const [checked, setChecked] = useState(false);
  const navigation = useNavigation();

  const handleCheck = () => {
    setChecked(!checked);
  };

  const handleDetails = () => {
    navigation.navigate("ToDoDetail", { item })
    
  }

  return (
    <View style={styles.card}>
      <TouchableOpacity onPress={handleCheck}>
        <View style={styles.checkBox}>
          {checked && <View style={styles.checkedIcon} />}
        </View>
      </TouchableOpacity>
      <Text style={styles.name}>{item.name}</Text>
      <Button
        onPress={handleDetails}
      >
        <Text style={styles.detailButton}>상세보기</Text>
      </Button>
    </View>
  );
};

const styles = StyleSheet.create({
  card: {
    flexDirection: 'row',
    alignItems: 'center',
    padding: 10,
    borderRadius: 5,
    backgroundColor: '#fff',
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.25,
    shadowRadius: 3.84,
    elevation: 5,
  },
  checkBox: {
    width: 20,
    height: 20,
    borderRadius: 10,
    borderWidth: 1,
    borderColor: '#ccc',
    marginRight: 10,
  },
  checkedIcon: {
    width: 10,
    height: 10,
    borderRadius: 5,
    backgroundColor: '#000',
  },
  name: {
    flex: 1,
    fontSize: 16,
  },
  detailButton: {
    color: '#000',
    fontSize: 14,
  },
});