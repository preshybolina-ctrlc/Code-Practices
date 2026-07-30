package com.example.profilecardpractice

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import com.example.profilecardpractice.ui.theme.ProfileCardPracticeTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// ==========================================
// 1. HELPER COMPONENT - STAT ITEM
// ==========================================
@Composable
fun PracticeStatItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

// ==========================================
// 2. HEADER SECTION (BANNER + AVATAR)
// ==========================================
@Composable
fun ProfileHeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        // Banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
        )
        // Overlapping Avatar
        Box(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.BottomCenter)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
                .border(4.dp, MaterialTheme.colorScheme.surface, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile Picture",
                modifier = Modifier.size(60.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

// ==========================================
// 3. ACTION BUTTONS ROW
// ==========================================
@Composable
fun ActionButtonsRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            onClick = { },
            modifier = Modifier.weight(1f)
        ) {
            Text("Book Session")
        }
        OutlinedButton(
            onClick = { },
            modifier = Modifier.weight(1f)
        ) {
            Text("Send Email")
        }
    }
}

// ==========================================
// 4. MAIN SCREEN (SCAFFOLD)
// ==========================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticeProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mentor Profile") },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileHeaderSection()

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Alan Turing",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Computer Scientist & Algorithm Expert",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(16.dp))

            ActionButtonsRow()

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // HERE IS WHERE THE HELPER COMPONENT IS USED:
                    PracticeStatItem(value = "4.9 ★", label = "Rating")
                    PracticeStatItem(value = "1.2k", label = "Mentees")
                    PracticeStatItem(value = "340", label = "Reviews")
                }
            }
        }
    }
}

// ==========================================
// 5. PREVIEWS (LIGHT & DARK MODE)
// ==========================================
@Preview(name = "Light Mode", showBackground = true)
@Composable
fun PracticeLightPreview() {
    ProfileCardPracticeTheme(darkTheme = false) {
        PracticeProfileScreen()
    }
}

@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PracticeDarkPreview() {
    ProfileCardPracticeTheme(darkTheme = true) {
        PracticeProfileScreen()
    }
}