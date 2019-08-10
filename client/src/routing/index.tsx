import React from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import HomeContainer from "../containers/home/Home";
import Navigation from "../containers/navigation/Navigation";

function NavRouter() {
  return (
    <Router>
      <Navigation />
      <Route exact path="/home" component={HomeContainer} />
    </Router>
  );
}

export default NavRouter;
