import {GET_DATA, IActions} from '../actions/actionTypes';
import IDataState from '../interfaces/IDataState';

const initialState: IDataState = {
    data: [],
}

export function dataReducer(state=initialState, action: IActions): IDataState {
    switch(action.type) {
        case GET_DATA: {
            return {
                ...state,
               data: action.payload
            }
        }
        default: {
            return state;
        }
    }
}
