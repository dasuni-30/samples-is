package com.wso2_sample.api_auth_sample.features.add_pet.presentation.screens.add_pet

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wso2_sample.api_auth_sample.features.add_pet.presentation.util.AddPetCard
import com.wso2_sample.api_auth_sample.features.add_pet.presentation.util.TopBar
import com.wso2_sample.api_auth_sample.ui.theme.Api_authenticator_sdkTheme
import com.wso2_sample.api_auth_sample.util.ui.LoadingDialog

@Composable
internal fun AddPetScreen(
    viewModel: AddPetScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    val navigateToHome: () -> Unit = viewModel::navigateToHome

    LoadingDialog(isLoading = state.value.isLoading)
    AddPetScreenContent(state.value, navigateToHome)
}

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun AddPetScreenContent(
    state: AddPetScreenState,
    navigateToHome: () -> Unit = {}
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            TopBar(navigateToHome = navigateToHome)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            AddPetCard()
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(horizontal = 32.dp)
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = { Text(text = "Pet Name") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = MaterialTheme.colorScheme.background,
                        focusedContainerColor = MaterialTheme.colorScheme.background,
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.tertiaryContainer,
                        unfocusedLabelColor = MaterialTheme.colorScheme.tertiaryContainer,
                        focusedLabelColor = MaterialTheme.colorScheme.tertiaryContainer
                    )
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = { Text(text = "Pet Breed") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = MaterialTheme.colorScheme.background,
                        focusedContainerColor = MaterialTheme.colorScheme.background,
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.tertiaryContainer,
                        unfocusedLabelColor = MaterialTheme.colorScheme.tertiaryContainer,
                        focusedLabelColor = MaterialTheme.colorScheme.tertiaryContainer
                    )
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    label = { Text(text = "Date of Birth") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = MaterialTheme.colorScheme.background,
                        focusedContainerColor = MaterialTheme.colorScheme.background,
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.tertiaryContainer,
                        unfocusedLabelColor = MaterialTheme.colorScheme.tertiaryContainer,
                        focusedLabelColor = MaterialTheme.colorScheme.tertiaryContainer
                    )
                )
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    Text(
                        text = "Add Pet",
                        color = MaterialTheme.colorScheme.surface
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun AddPetScreenPreview() {
    Api_authenticator_sdkTheme {
        AddPetScreenContent(
            state = AddPetScreenState(
                isLoading = false
            )
        )
    }
}