import axios from "axios";

const API_BASE_URL = "http://localhost:8080/restaurant/manager"; // Backend URL

export const getTables = async (restaurantId) => {
  return axios.get(`${API_BASE_URL}/tables/${restaurantId}`);
};

export const addTable = async (data) => {
  return axios.post(`${API_BASE_URL}/addTables`, data);
};

export const getMenu = async (restaurantId) => {
  return axios.get(`${API_BASE_URL}/getMenu/${restaurantId}`);
};

export const addMenuItem = async (data) => {
  return axios.post(`${API_BASE_URL}/addMenuItem`, data);
};