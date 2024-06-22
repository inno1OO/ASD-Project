import { StatusBar } from 'expo-status-bar';
import { Platform, StyleSheet } from 'react-native';
import { useContext, useState } from "react";
import { KeyboardAvoidingView, TextInput, TouchableWithoutFeedback, TouchableHighlight, Keyboard, Image, TouchableNativeFeedback, Alert } from "react-native";
import { signIn } from "../../services";
import AppContext from "../../AppContext";
import AsyncStorage from "@react-native-async-storage/async-storage";
import jwtDecode from 'jwt-decode';

import EditScreenInfo from '@/components/EditScreenInfo';
import { Text, View } from '@/components/Themed';
// import { Text } from 'react-native-reanimated/lib/typescript/Animated';

const SignIn = ({navigation})=>{

    const [auth, setAuth] = useState({username:"", password:""});
    const [showPassword, setShowPassword] = useState(false);
    const SECRET = "FBD9AA867A4F3DD5DAD456D2E8688";
    const {state, setState} = useContext(AppContext);

    const onUsernameChange = (value) => {
        setAuth({...auth, username:value})
    }

    const onPasswordChange = (value) => {
        setAuth({...auth, password:value})
    }

    const onSignIn = async () =>{
        const res = await signIn(auth);
        
        if (res.success) {
            const decodedValue = jwtDecode(res.data);
            console.log("data from token", decodedValue.username);
            console.log("sign in result", res.data);
            setState({...state, token:res.data, userid: res.userid, email: decodedValue.email, 
              phone:decodedValue.phone, fullname:decodedValue.fullname, address:decodedValue.address});
            const userData = {
              token:res.data,
              userid:res.userid,
              email:decodedValue.email,
              phone:decodedValue.phone,
              fullname:decodedValue.fullname,
              address:decodedValue.address
            }

            await AsyncStorage.setItem("manageapp", JSON.stringify(userData));
            
        }else{
            console.log("sign in false result", res);
            Alert.alert(res.data);
        }
    }

    const onSignUp = () => {
        navigation.navigate('sign-up');
    }

    return (
           <KeyboardAvoidingView style={styles.container}>
            {/* <TouchableWithoutFeedback onPress={Keyboard.dismiss}> */}
                <View  style={styles.containerView}>
                <Image source={require('../../assets/images/icon.png')} style={styles.image}/>
                <Text style={styles.header}>Sign In</Text>
                <TextInput value={auth.username} onChangeText={onUsernameChange} style={styles.textInput} placeholder="Username"/>
                <TextInput value={auth.password} secureTextEntry={!showPassword} onChangeText={onPasswordChange} style={styles.textInput} placeholder="Password"/>
               
                <View style={styles.btnContainer}>
                    <TouchableHighlight style={styles.button} onPress={onSignIn}>
                        <Text style={styles.btnText}>Sign In</Text>
                    </TouchableHighlight>
                    <TouchableWithoutFeedback onPress={onSignUp} >
                        <Text style={styles.signUpText}>Don't have an account? Sign Up</Text>
                    </TouchableWithoutFeedback>
                </View>
                </View>
            {/* </TouchableWithoutFeedback> */}
         </KeyboardAvoidingView>
    );
}


const styles = StyleSheet.create({
    container: {
      
    backgroundColor:'white',
      flex:1
    },
    inner: {
      padding: 24,
      flex: 1,
      justifyContent: 'space-around',
    },
    header: {
      fontSize: 36,
      marginBottom: 50,
      textAlign:"center"
    },
    textInput: {
      height: 40,
      borderColor: '#000000',
      borderBottomWidth: 1,
      marginBottom: 50,
    },
    btnContainer: {
      alignItems:"center",
      marginTop: 12,
    },
    button:{
        borderRadius:20,
        border: "#FF4B2B",
        backgroundColor: "#BABABA",
        color: "#bababa",
        fontSize:12,
        fontWeight:"bold",
        width:"90%",
        padding:20,
        marginBottom:50
      },
      btnText:{
        textAlign:"center"
      },
      signUpText:{
        marginTop:40
      },
      image:{
        alignItems:"center",
        position:"relative",
        margin:"auto"
      },
      containerView:{
        padding: 24,
        flex: 1,
        
      }
  });

export default SignIn;