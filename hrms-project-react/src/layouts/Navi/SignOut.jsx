import React from 'react'
import { Button, Dropdown } from 'semantic-ui-react'

const options = [
    { key: 'login', icon: 'lock', text: 'Login', value: 'login' },
    { key: 'try', icon: 'signup', text: 'Try for Free', value: 'try' }
]


export default function SignOut({signIn}) {
    return (
        <div>
            <Button
                as='a'
                onClick={signIn}
            >
                Log in
            </Button>
            <Button
                as='a'
                inverted color='grey'
                style={{ marginLeft: '0.5em' }}
            >
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
        </div>
    )
}
