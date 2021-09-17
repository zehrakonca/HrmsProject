import React from 'react'
import { Table } from 'semantic-ui-react'

export default function Employer() {
    return (
        <div>
            <Table celled padded>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Company Mail</Table.HeaderCell>
                        <Table.HeaderCell>Company Name</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>
                <Table.Body>
                    <Table.Row>
                        <Table.Cell singleLine>Company Mail</Table.Cell>
                        <Table.Cell>
                            Company Name
                        </Table.Cell>
                    </Table.Row>
                </Table.Body>
            </Table>
        </div>
    )
}
