import './App.css';
import Navi from './layouts/Navi/Navi';
import { Container } from 'semantic-ui-react'
import 'semantic-ui-css/semantic.min.css'
import Home from './pages/Home/Home';
import Footer from './layouts/Footer/Footer';
import JobAdvertisements from './pages/JobAdvertisement/JobAdvertisements';
import SignupEmployer from './pages/Signup/SignupEmployer';
import Login from './pages/Login/Login';
import SignupJobSeeker from './pages/Signup/SignupJobSeeker';
import Dashboard from './layouts/Dashboard/Dashboard';
import JobDetail from "./pages/JobAdvertisement/JobDetail";
import { Route } from 'react-router';
import JobAdvertisementPosting from './pages/JobAdvertisement/JobAdvertisementPosting';
import UpdateJobAdvertisement from './pages/SystemEmployee/UpdateJobAdvertisement'


function App() {
  return (
    <div className="App">
      <Navi />
      <Container className="main" >
        <Route exact path="/">
          <Home></Home>
        </Route>
        <Route exact path="/dashboard">
        <Dashboard />
        </Route>
        <Route exact path="/Login">
          <Login></Login>
        </Route>
        <Route exact path="/signUpForEmployer">
          <SignupEmployer></SignupEmployer>
        </Route>
        <Route exact path="/signUpForJobSeeker">
          <SignupJobSeeker></SignupJobSeeker>
        </Route>
        <Route exact path="/advertisements">
          <Dashboard />
        </Route>
        <Route exact path="/advertisements/:id" component={JobDetail} />   
        <Route exact path="/advertisementpost" component={JobAdvertisementPosting}/>
        <Route exact path="/advertisementPassive" component={UpdateJobAdvertisement}/>
      </Container>
      <Footer></Footer>
    </div>
  );
}

export default App;
