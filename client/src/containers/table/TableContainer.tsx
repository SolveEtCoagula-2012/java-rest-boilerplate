import * as React from "react";
import { connect } from "react-redux";
import { AgGridReact } from "ag-grid-react";
import "ag-grid-community/dist/styles/ag-grid.css";
import "ag-grid-community/dist/styles/ag-theme-balham.css";
import ITableState from "./ITableState";

interface ITableProps {
  actions?: any;
}

class TableContainer extends React.Component<ITableProps, ITableState> {
  constructor(props: any) {
    super(props);
    this.state = {
      columnDefs: [
        {
          headerName: "Make",
          field: "make"
        },
        {
          headerName: "Model",
          field: "model"
        },
        {
          headerName: "Price",
          field: "price"
        }
      ],
      rowData: [
        {
          make: "Toyota",
          model: "Celica",
          price: 35000
        },
        {
          make: "Ford",
          model: "Mondeo",
          price: 32000
        },
        {
          make: "Porsche",
          model: "Boxter",
          price: 72000
        }
      ]
    };
  }

  public render() {
    const { columnDefs, rowData } = this.state;
    
    return (
      <div
        className={"ag-theme-balham"}
        style={{ height: "500px", width: "600px" }}
      >
        <AgGridReact columnDefs={columnDefs}  rowData={rowData}/>
      </div>
    );
  }
}

export default connect()(TableContainer);
