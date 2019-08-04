import {serverReducer} from './reducers/mainReducer';
import {combineReducers, applyMiddleware, createStore} from 'redux';
import thunkMiddleware from "redux-thunk";
import { composeWithDevTools } from "redux-devtools-extension";
import { dataReducer } from './reducers/dataReducer';

const rootReducer = combineReducers({
    serverCheck: serverReducer,
    items:  dataReducer
});

export type GlobalState = ReturnType<typeof rootReducer>;

export default function configStore() {
    const middlewares = [thunkMiddleware];
    const middlewaresEnchancers = applyMiddleware(...middlewares);

    const store = createStore(
        rootReducer,
        composeWithDevTools(middlewaresEnchancers)
    );

    return store;
}