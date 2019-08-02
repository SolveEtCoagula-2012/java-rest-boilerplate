import {CHECK_SERVER} from './actionTypes';
import {BASE_URI} from '../../utils/constants';
import { ThunkAction } from 'redux-thunk';

import { Action } from 'redux';

export const thunkSendMessage = (): ThunkAction<void, null, null, Action<string>> => async dispatch => {
    const res = await checkIfServerAlive();
    dispatch( sendMessage(res))
};

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
        }).catch((error) => false);
}
