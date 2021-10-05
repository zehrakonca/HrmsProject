import React from 'react'
import { Dropdown, Menu, Image } from 'semantic-ui-react'
import avatarSıgnIn from '../../img/avatarForSıgnIn.png';

export default function SignedIn({signOut}) {
    return (
        <div>
            <Menu.Item>
                <Image avatar spaced="left" src={avatarSıgnIn} />
                <Dropdown pointing="top right" text="Zehra">
                    <Dropdown.Menu>
                        <Dropdown.Item text="My Account" icon="user outline" />
                        <Dropdown.Item text="Help" icon="help" />
                        <Dropdown.Item
                            text="Log out"
                            icon="sign out"
                            onClick={signOut} />
                    </Dropdown.Menu>
                </Dropdown>
            </Menu.Item>
        </div>
    )
}
