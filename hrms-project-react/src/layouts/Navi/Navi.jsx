import React, { useState } from 'react'
import { useHistory } from 'react-router'
import { Link } from 'react-router-dom'
import { Menu, Icon } from 'semantic-ui-react'
import SignedIn from './SignedIn'
import SignOut from './SignOut'

export default function Navi() {
    const [isAuthenticated, setIsAuthenticated] = useState(true)
    const history = useHistory()

    function handleSignOut() {
        setIsAuthenticated(false)
        history.push("/")
    }

    function handleSignIn() {
        setIsAuthenticated(true)
    }

    return (
        <div>
            <Menu secondary size='large' inverted color='teal' stackable >
                <Menu.Item>
                <Link to="/Home">
                    <Icon name='handshake outline' size='big' />
                    ihopefindjob
                    </Link>
                </Menu.Item>
                <Menu.Item active>
                <Link to="/home">Home</Link>
                </Menu.Item>
                <Menu.Item>
                    <Link to="/advertisements">Job Advertisements</Link>
                </Menu.Item>
                <Menu.Item>
                    <Link to="/Login">University Directory(login)</Link>
                </Menu.Item>
                <Menu.Item>
                   
                </Menu.Item>
                <Menu.Item as='a'>
                    {/* <Search placeholder='Write the job you are looking for.' /> */}
                </Menu.Item>
                <Menu.Item position='right'>
                    {isAuthenticated ? <SignedIn signOut={handleSignOut} /> : <SignOut signIn={handleSignIn} />}
                </Menu.Item>
            </Menu>
        </div>
    )
}