import React from 'react'
import { Button, Menu, Icon, Search, Dropdown } from 'semantic-ui-react'

const options = [
    { key: 'login', icon: 'lock', text: 'Login', value: 'login' },
    { key: 'try', icon: 'signup', text: 'Try for Free', value: 'try' }
]

export default function Navi() {
    return (
        <div>
            <Menu secondary size='large' inverted color='teal' stackable >
                <Menu.Item>
                    <Icon name='handshake outline' size='big' />
                    ihopefindjob
                </Menu.Item>
                <Menu.Item as='a' active>
                    Home
                </Menu.Item>
                <Menu.Item as='a'>Job Advertisements</Menu.Item>
                <Menu.Item as='a'>University Directory</Menu.Item>
                <Menu.Item as='a'>Business Directory</Menu.Item>
                <Menu.Item as='a'>
                    <Search placeholder='Write the job you are looking for.' />
                </Menu.Item>
                <Menu.Item position='right'>
                    <Button as='a'>
                        Log in
                    </Button>
                    <Button as='a' inverted color='grey' style={{ marginLeft: '0.5em' }}>
                        Sign Up
                    </Button>
                    <Button.Group inverted color='grey'>
                    <Button as='a' style={{ marginLeft: '0.5em' }}>
                        For Employer
                    </Button>
                    <Dropdown
                        className='button icon'
                        floating
                        options={options}
                        trigger={<></>}
                    />
                     </Button.Group>
                </Menu.Item>
            </Menu>
        </div>
    )
}