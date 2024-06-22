import React from 'react';
import FontAwesome from '@expo/vector-icons/FontAwesome';
import { DarkTheme, DefaultTheme, ThemeProvider } from '@react-navigation/native';
import { useFonts } from 'expo-font';
import { Stack } from 'expo-router';
import * as SplashScreen from 'expo-splash-screen';
import { useEffect, useState } from 'react';
import AppContext from '../AppContext';
import AsyncStorage from '@react-native-async-storage/async-storage';
import 'react-native-reanimated';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { useColorScheme } from '@/components/useColorScheme';
import { NavigationContainer } from '@react-navigation/native';
import SignIn from './components/SignIn';
import { Ionicons } from '@expo/vector-icons';

export {
  // Catch any errors thrown by the Layout component.
  ErrorBoundary,
} from 'expo-router';

export const unstable_settings = {
  // Ensure that reloading on `/modal` keeps a back button present.
  initialRouteName: '(tabs)',
};

// Prevent the splash screen from auto-hiding before asset loading is complete.
SplashScreen.preventAutoHideAsync();

export default function RootLayout() {
  const [loaded, error] = useFonts({
    SpaceMono: require('../assets/fonts/SpaceMono-Regular.ttf'),
    ...FontAwesome.font,
  });

  
  const [state, setState] = useState(
    {
      token:"", 
      userid:"", 
      email:"", 
      phone:"", 
      fullname:"", 
      address:""
    });

  const logOut = async () =>{
    try {
      await AsyncStorage.removeItem("manageapp");
      setState({...state, token:""});
    } catch (error) {
      console.log("logout", error);
    }
  }

  const Tab = createBottomTabNavigator();
  const Stack = createNativeStackNavigator(); 

  // Expo Router uses Error Boundaries to catch errors in the navigation tree.
  useEffect(() => {
    if (error) throw error;
  }, [error]);

  useEffect(() => {
    if (loaded) {
      SplashScreen.hideAsync();
    }
  }, [loaded]);

  if (!loaded) {
    return null;
  }

  return (
    <AppContext.Provider value={{state, setState, logOut}}>
     

   
      <Stack.Navigator initialRouteName="components/SignIn">
        <Stack.Screen name='components/SignIn' component={SignIn} options={{headerShown: false}} />
        
      </Stack.Navigator>
    
    
   
  </AppContext.Provider>
  );
}


