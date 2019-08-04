import {CHECK_SERVER, GET_DATA} from './actionTypes';
import {BASE_URI} from '../../utils/constants';
import { ThunkAction } from 'redux-thunk';

import { Action } from 'redux';

export const thunkSendMessage = (): ThunkAction<void, null, null, Action<string>> => async dispatch => {
    const res = await checkIfServerAlive();
    dispatch( sendMessage(res))
};

export const thunkGetData = (): ThunkAction<void, null, null, Action<string>> => async dispatch => {
    const res = await getData();
    dispatch(setDataToState(res));
}

export function setDataToState(data: any[]) {
    return {
        type: GET_DATA,
        payload: data,
    }
}

export function sendMessage(message: boolean){
    return {
        type: CHECK_SERVER,
        payload: message
    }
}

export function checkIfServerAlive(): Promise<boolean> {
    return fetch(`${BASE_URI}/check`)
        .then(response => response.json())
        .then(res => {
            return res.succesful ? true : false
        })
        .catch((error) => false);
}

export function getData(): Promise<any> {
    return fetch(`${BASE_URI}/get`)
        .then(response => response.json())
        .then(res => res)
        // .catch((e) => e) <-- TODO this error must be handled in the future
}