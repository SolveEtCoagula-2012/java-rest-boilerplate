export const CHECK_SERVER = 'CHECK_SERVER';
export const GET_DATA = 'GET_DATA';

interface CHECK_SERVER {
    type: typeof CHECK_SERVER;
    payload: boolean
}

interface GET_DATA {
    type: typeof GET_DATA;
    payload: any[]
}

export type IActions = CHECK_SERVER | GET_DATA;