import axios from "axios";
import { create } from "zustand";

export const useToDoList = create((set) => ({
    toDoLists: [],

    fetchToDoList: async (url = '/api/todoList') => {
        set({ loading: true, error: null });
        try {
            const response = await axios.get(url);
            const data = response.data;

            set({ toDoLists: data.results });
            set({ loading: false });

        } catch (error) {
            console.error(error); // Log the error for debugging
            set({ loading: false, error: 'Failed to fetch Pokemon' }); // Set a generic error message for the user
        }
    }
}))
