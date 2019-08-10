export interface ITableColumns {
    headerName: string;
    field: string;
}

export interface ITableRowData {
    make: string;
    model: string;
    price: number;
}

export default interface ITableState {
    columnDefs: ITableColumns[];
    rowData: ITableRowData[];
}